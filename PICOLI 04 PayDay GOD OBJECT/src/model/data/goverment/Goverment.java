package model.data.goverment;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.data.being.Being;

public class Goverment {
	private int initialPopulation = 10;
	private PropertyChangeListener adultChangeListener, ancientChangeListener;
	// PAyDay
	
	private LinkedList<LinkedList<Being>> poblacion = new LinkedList<>();
	private LinkedList<Being> youngs;
	// esto es sustituido
	private final int produccionPorTrabajador = 400;
	private long produccionSolicitada;
	private long capital = 0;
	private LinkedList<Being> ancianos;
	// sutituyen a adultos
	private LinkedList<Being> adults;
	private LinkedList<Being> trabajadores;
	private LinkedList<Being> parados;
	
	public Goverment(int initialPopulation) {
		this.initialPopulation = initialPopulation;
		prepareState(initialPopulation);
	}

	public Goverment(int initialPopulation, int lifeExpenctacy) {
		this.initialPopulation = initialPopulation;
		prepareState(initialPopulation, lifeExpenctacy);
	}

	public Goverment() {
		super();
		prepareState(initialPopulation);

	}

	// funciones a realizar
	public void gestionarPeriodo(float incremento) {
		cerrarPeriodoAnterior();
		abrirPeriodoActual(incremento);
	}

	private void abrirPeriodoActual(float incremento) {
		produccionSolicitada = calculaDemanda(incremento);
		long diferencia = produccionSolicitada - calcularProduccionTotal();
		gestionEmpleados(diferencia);
		gestionNacimientos();
	}

	private void gestionNacimientos() {
		// TODO Auto-generated method stub

	}

	private void gestionEmpleados(long diferencia) {
		// TODO Auto-generated method stub

	}

	private long calculaDemanda(float incremento) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void cerrarPeriodoAnterior() {
		pagarPoblacion();
		envejecerPoblacion();
		enterrarMuertos();
	}

	private void envejecerPoblacion() {
		// TODO
	}
	private void enterrarMuertos() {
		// TODO Auto-generated method stub
		
	}
	private void pagarPoblacion() {
		capital += calcularProduccionTotal();
		long pagoParados = pagarAParados();
		capital -= pagoParados;
		pagarATrabajadores();
		pagoAMenores();
		pagoAAncianos();
	}

	private int calcularProduccionTotal() {
		return trabajadores.size() * produccionPorTrabajador;
	}
	
	private int calcularProduccionPotencial() {
		return adults.size()*produccionPorTrabajador;
	}

	private void pagarATrabajadores() {
		// TODO Auto-generated method stub

	}

	private void pagoAAncianos() {
		// TODO Auto-generated method stub

	}

	private void pagoAMenores() {
		// TODO Auto-generated method stub

	}

	private long pagarAParados() {
		// TODO Auto-generated method stub
		return 0;
	}

	// payday
	public LinkedList<Being> getYoungs() {
		return youngs;
	}

	public LinkedList<Being> getAncients() {
		return ancianos;
	}
	//PayDay
	

	

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
		youngs = new LinkedList<>();
		ancianos = new LinkedList<>();
		poblacion = new LinkedList();
		adults = new LinkedList<>();
		poblacion.add(youngs);
		poblacion.add(adults);
		poblacion.add(ancianos);
		parados=new LinkedList<>();
		trabajadores=new LinkedList<>();
	}

	private void raisePopulation(int initialPopulation, int lifeExpenctancy) {
		for (int i = 0; i < initialPopulation; i++) {
			Being e = new Being(lifeExpenctancy);
			e.addPropertyAdultChangeListener(adultChangeListener);
			e.addPropertyAncientChangeListener(ancientChangeListener);
			youngs.add(e);
		}
	}

	private void raisePopulation(int initialPopulation) {
		for (int i = 0; i < initialPopulation; i++) {
			Being e = new Being();
			e.addPropertyAdultChangeListener(adultChangeListener);
			e.addPropertyAncientChangeListener(ancientChangeListener);
			youngs.add(e);
		}
	}

	public void developWorld(int years) {
		for (int i = 0; i < years; i++) {
			feed();
			bury();
		}
	}

	private void bury() {
		// sacar a los muertos
		poblacion.forEach(list -> list.removeIf(being -> !being.isAlive()));
	}

	// Resulta que un problema d e los streams es que no podemos borrar en una
	// coleccion mientras se
	// recorre.
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

}
