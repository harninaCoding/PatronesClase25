package model.data.goverment;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.data.being.AdultBehaviour;
import model.data.being.Being;
import model.data.being.CalculableParo;

public class Government {
	private int initialPopulation = 10;
	private PropertyChangeListener adultChangeListener, ancientChangeListener;
	// PAyDay

	private LinkedList<LinkedList<Being>> poblacion = new LinkedList<>();
	private LinkedList<Being> youngs;
	// esto es sustituido
	private final int produccionPorTrabajador = 400;
	private long produccionSolicitada = 1000;
	

	private long capital = 0;
	private LinkedList<Being> ancianos;
	// sutituyen a adultos
	private LinkedList<Being> adults;
	private LinkedList<Being> trabajadores;
	private LinkedList<Being> parados;
	private final float PORCENTAJE_MINIMO_MENOR = 0.55f;
	private final float PORCENTAJE_MINIMO_ADULTO = .5f;
	private final float PORCENTAJE_MINIMO_ANCIANO = 0.3f;
	private ArrayDeque<Long> incrementosHistorial;
	private long cantidadMuertosPeriodoActual = 0;

	public Government(int initialPopulation) {
		this.initialPopulation = initialPopulation;
		prepareState(initialPopulation);
		createIncrementos();
	}

	public Government(int initialPopulation, int lifeExpenctacy) {
		this.initialPopulation = initialPopulation;
		prepareState(initialPopulation, lifeExpenctacy);
		createIncrementos();
	}

	public long getCapital() {
		return capital;
	}

	public void setCapital(long capital) {
		this.capital = capital;
	}

	private long getIncrementoMedio() {
		return (long) incrementosHistorial.stream().mapToLong(incremento -> incremento).average().getAsDouble();
	}

	private void addPeriodoDeIncremento(long incremento) {
		// al final de la cola
		incrementosHistorial.offer(incremento);
		// el primero de la cola
		incrementosHistorial.poll();
	}

	private void createIncrementos() {
		// por ejemplo cinco periodos
		incrementosHistorial = new ArrayDeque<>();
		incrementosHistorial.add(0L);
		incrementosHistorial.add(0L);
		incrementosHistorial.add(0L);
		incrementosHistorial.add(0L);
		incrementosHistorial.add(0L);
	}

	

	// punto de entrada
	public void gestionarPeriodo(float incremento) throws Exception {
		cerrarPeriodoAnterior();
		abrirPeriodoActual(incremento);
	}

	private void abrirPeriodoActual(float incremento) throws Exception {
		calculaDemanda(incremento);
		long diferencia = produccionSolicitada - calcularProduccionTotal();
		diferencia = gestionEmpleados(diferencia);
		gestionNacimientos(incremento);
	}

	private void gestionNacimientos(float incremento) {
		addPeriodoDeIncremento((long) incremento);
		long incrementoMedio = getIncrementoMedio();
		long nuevos = cantidadMuertosPeriodoActual + cantidadMuertosPeriodoActual * incrementoMedio;
		for (int i = 0; i < nuevos; i++) {
			youngs.add(new Being(this));
		}
	}

	private long gestionEmpleados(long diferencia) {
		long personas = Math.abs(diferencia) / produccionPorTrabajador;
		int contador = 0;
		if (diferencia >= 0) {
			contador = cambiarCola(personas, parados, trabajadores);
			return diferencia -= contador * produccionPorTrabajador;
		} else {
			contador = cambiarCola(personas, trabajadores, parados);
			return diferencia += contador * produccionPorTrabajador;
		}
	}

	private int cambiarCola(long personas, Deque<Being> origen, Deque<Being> destino) {
		int contador = 0;
		while (contador < personas && !origen.isEmpty()) {
			destino.push(origen.poll());
			contador++;
		}
		return contador;
	}

	private void calculaDemanda(float incremento) throws Exception {
		if (incremento < -.99f || incremento > .99f)
			throw new Exception("valor de incremento incorrecto");
		produccionSolicitada += produccionSolicitada * incremento;
	}

	private void cerrarPeriodoAnterior() {
		pagarPoblacion();
		envejecerPoblacion();
		cantidadMuertosPeriodoActual = enterrarMuertos();
	}

	private void envejecerPoblacion() {
		poblacion.forEach(grupo -> grupo.forEach(Being::aging));
		adults.stream().filter(being -> !being.isAlive())
				.forEach(adult -> ((AdultBehaviour) adult.getBehaviour()).entregarAhorros());
	}

	private long enterrarMuertos() {
		enterrarGrupo(parados);
		enterrarGrupo(trabajadores);
		return enterrarGrupo(youngs) + enterrarGrupo(adults) + enterrarGrupo(ancianos);
	}

	private long enterrarGrupo(List<?> grupo) {
		long contador = 0;
		for (Iterator iterator = grupo.iterator(); iterator.hasNext();) {
			Being being = (Being) iterator.next();
			if (!being.isAlive()) {
				iterator.remove();
				contador++;
			}
		}
		return contador;
	}

	public void pagarPoblacion() {
		capital += calcularProduccionTotal();
		long pagoParados = pagarAParados();
		capital -= pagoParados;
		pagoAMenores();
		pagarATrabajadores();
		pagoAAncianos();
	}

	private int calcularProduccionTotal() {
		return trabajadores.size() * produccionPorTrabajador;
	}

	private int calcularProduccionPotencial() {
		return adults.size() * produccionPorTrabajador;
	}

	private long pagarAParados() {
		return parados.stream().mapToLong(parado -> {
			long calculate = ((CalculableParo) parado).calculate();
			parado.live(parado.getVitalNecesity());
			return calculate;
		}).sum();
	}

	private void pagarATrabajadores() {
		pagarGrupo(trabajadores, Being.vitalNecesity * 2, PORCENTAJE_MINIMO_ADULTO);
	}

	private void pagoAMenores() {
		pagarGrupo(youngs, Being.vitalNecesity, PORCENTAJE_MINIMO_MENOR);
	}

	private void pagoAAncianos() {
		pagarGrupo(ancianos, Being.vitalNecesity, PORCENTAJE_MINIMO_ANCIANO);

	}

	private void pagarGrupo(List<Being> grupo, int necesidad, float porcentajeMinimo) {
		if (!grupo.isEmpty()) {
			long presupuestoNecesario = calcularPresupuestoGrupo(grupo.size(), necesidad);
			long capitalDisponible = capital;
			long pagoTotal;
			if (capitalDisponible >= presupuestoNecesario) {
				pagoTotal = presupuestoNecesario;
			} else {
				pagoTotal = capitalDisponible;
				long minimoAceptable = (long) (presupuestoNecesario * porcentajeMinimo);
				if (pagoTotal < minimoAceptable) {
					pagoTotal = minimoAceptable;
				}
			}
			int pago = (int) (pagoTotal / grupo.size());
			for (Being ser : grupo) {
				ser.live(pago);
			}
		}
	}

	private long calcularPresupuestoGrupo(int size, int necesidad) {
		return size * necesidad;
	}

	// payday
	public LinkedList<Being> getYoungs() {
		return youngs;
	}

	public List<Being> getTrabajadores() {
		return trabajadores;
	}

	public List<Being> getParados() {
		return parados;
	}

	public LinkedList<Being> getAncients() {
		return ancianos;
	}
	// PayDay

	private void createListeners() {
		adultChangeListener = (being) -> {
			applyLambda(being, youngs, adults);
		};
		ancientChangeListener = (being) -> {
			applyLambda(being, adults, ancianos);
		};
	}

	private void applyLambda(PropertyChangeEvent being, List<Being> source, List<Being> destination) {
		Being remove = source.remove(source.indexOf(being.getNewValue()));
		destination.add(remove);
	}

	private void prepareState(int initialPop) {
		createLists();
		createListeners();
		raisePopulation(initialPop);
	}

	private void prepareState(int initialPop, int lifeExpenctacy) {
		createLists();
		createListeners();
		raisePopulation(initialPop, lifeExpenctacy);
	}

	private void createLists() {
		youngs = new LinkedList<Being>();
		ancianos = new LinkedList<Being>();
		poblacion = new LinkedList<LinkedList<Being>>();
		adults = new LinkedList<Being>();
		poblacion.add(youngs);
		poblacion.add(adults);
		poblacion.add(ancianos);
		parados = new LinkedList<Being>();
		trabajadores = new LinkedList<Being>();
	}

	private void raisePopulation(int initialPopulation, int lifeExpenctancy) {
		for (int i = 0; i < initialPopulation; i++) {
			Being e = new Being(lifeExpenctancy, this);
			e.addAdultPropertyChangeListener(adultChangeListener);
			e.addAncientPropertyChangeListener(ancientChangeListener);
			youngs.add(e);
		}
	}

	private void raisePopulation(int initialPopulation) {
		for (int i = 0; i < initialPopulation; i++) {
			Being e = new Being(this);
			e.addAdultPropertyChangeListener(adultChangeListener);
			e.addAncientPropertyChangeListener(ancientChangeListener);
			youngs.add(e);
		}
	}

	private void iterateCollectionForLiving(LinkedList<Being> colection) {
		LinkedList<Being> others = (LinkedList<Being>) colection.clone();
		for (Iterator<Being> iterator = others.iterator(); iterator.hasNext();) {
			Being being = (Being) iterator.next();
			being.live(being.getVitalNecesity());
		}
	}

	private void feed() {
		iterateCollectionForLiving(youngs);
		iterateCollectionForLiving(adults);
		iterateCollectionForLiving(ancianos);
	}

	public LinkedList<Being> getAdults() {
		return adults;
	}

	public void recogerHerencia(long savings) {
		this.capital += savings;

	}
	public long getProduccionSolicitada() {
		return produccionSolicitada;
	}

	public void setProduccionSolicitada(long produccionSolicitada) {
		this.produccionSolicitada = produccionSolicitada;
	}
}
