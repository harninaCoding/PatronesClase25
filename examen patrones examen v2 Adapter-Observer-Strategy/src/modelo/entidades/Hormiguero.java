package modelo.entidades;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.adapter.Adapter;
import modelo.insectos.Hormiga;
import modelo.soporte.HormigaData;
import modelo.soporte.Statistics;

public class Hormiguero implements PropertyChangeListener {
	Statistics statistics;
	public final int cantidadHormigasTotal = 30;
	public final int cantidadHormigasGuerreras = 15;

	private boolean atacada = false;
	private boolean tareaAcabada = false;
	private final Adapter<Hormiga, HormigaData> adapter;

	private List<Hormiga> hormigas;
	private static long id = 1;

	public Hormiguero(Adapter<Hormiga, HormigaData> adapter) {
		super();
		hormigas = new ArrayList<Hormiga>();
		statistics = new Statistics();
		this.adapter = adapter;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		enterrarHormiga((Hormiga) evt.getNewValue());
	}

	public void funciona() {
		int historia = 0;
		int guerreras = 0;
		do {
			historia++;
			// las hormigas hacen lo que le toca
			for (int i = 0; i < hormigas.size(); i++) {
				Hormiga hormiga = hormigas.get(i);
				hormiga.hacerTarea();
			}
			if (historia % 100 == 0) {
				// estamos en guerra o en paz
				atacada = !atacada;
				if (atacada) {
					System.out.println("estamos en guerra");
					convertirHormigasGuerra(cantidadHormigasGuerreras - contarHormigasGuerreras());
				} else {
					// fin de la guerra
					System.out.println("volvemos a la paz");
					convertirHormigasPaz();
				}
			}
			// puede que se hayan muerto algunas
			if (atacada) {
				guerreras = cantidadHormigasGuerreras - contarHormigasGuerreras();
			} else {
				guerreras = 0;
			}
			crearHormigas(guerreras);
			if (historia == 410)
				setTareaAcabada(true);
		} while (!isTareaAcabada());
	}

	private void setTareaAcabada(boolean estado) {
		tareaAcabada = estado;
	}

	private boolean isTareaAcabada() {
		return tareaAcabada;
	}

	public List<Hormiga> getHormigas() {
		return hormigas;
	}

	public void setHormigas(List<Hormiga> hormigas) {
		this.hormigas = hormigas;
	}

	//Strategy
	private void convertirHormigasGuerra(int i) {
		int contador = 0;
		for (int j = 0; j < cantidadHormigasGuerreras; j++) {
			hormigas.get(j).hazteGuerrera();
			contador++;
		}
		System.out.println("hormigas  guerreras convertidas " + contador);
	}
	//Strategy

	//Strategy
	private void convertirHormigasPaz() {
		for (Hormiga hormiga : hormigas) {
			hormiga.hazteRecolectora();
		}
	}
	//Strategy

	//Strategy
	private int contarHormigasGuerreras() {
		int contador = 0;
		for (Hormiga hormiga : hormigas) {
			if (hormiga.isGuerrera())
				contador++;
		}
		return contador;
	}
	//Strategy

	private void enterrarHormiga(Hormiga next) {
		try {
			statistics.addData(adapter.convert(next));
		} catch (Exception e) {
		}
		hormigas.remove(next);
		next.removePropertyChangeListener(this);
	}

	private void crearHormigas(int guerreras) {
		int contador = 0;
		for (int i = hormigas.size(); i < cantidadHormigasTotal; i++) {
			Hormiga hormiga = new Hormiga(id++);
			hormiga.addPropertyChangeListener(this);
			if (guerreras-- > 0) {
				hormiga.hazteGuerrera();
				;
			}
			hormigas.add(hormiga);
			contador++;
		}
	}
}
