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

	//Observer
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		enterrarHormiga((Hormiga) evt.getNewValue());
	}
	//Observer
	
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
//                if (guerreras > 0) {
//                    System.out.println("hormigas guerreras muertas " + guerreras);
//                }
			} else {
				guerreras = 0;
			}
			//Observer
			//esto se quita porque es un polling
//			enterrarHormigas();
			// Observer
			crearHormigas(guerreras);
			if (historia == 410)
				tareaAcabada = true;
//            if (cantidad % 20 == 0) System.out.println("historia " + cantidad);
		} while (!isTareaAcabada());
		// mostrar estadisticas
//        System.out.println(statistics.getCurrentMediaAlimento());
//        System.out.println(statistics.getCurrentIndiceGlobal());
	}

	public List<Hormiga> getHormigas() {
		return hormigas;
	}

	public void setHormigas(List<Hormiga> hormigas) {
		this.hormigas = hormigas;
	}

	private void convertirHormigasGuerra(int i) {
		int contador = 0;
		for (int j = 0; j < cantidadHormigasGuerreras; j++) {
			hormigas.get(j).setGuerrera(true);
			contador++;
		}
		System.out.println("hormigas  guerreras convertidas " + contador);
	}

	private void convertirHormigasPaz() {
		int contador = 0;
		for (Hormiga hormiga : hormigas) {
			if (hormiga.isGuerrera()) {
				hormiga.setGuerrera(false);
				contador++;
			}
		}
		System.out.println("hormigas  convertidas a la paz " + contador);
	}

	private int contarHormigasGuerreras() {
		int contador = 0;
		for (Hormiga hormiga : hormigas) {
			if (hormiga.isGuerrera())
				contador++;
		}
		return contador;
	}

	//observer
	private void enterrarHormiga(Hormiga next) {
		statistics.addData(adapter.convert(next));
		hormigas.remove(next);
		next.removePropertyChangeListener(this);
	}
	//observer

	private void crearHormigas(int guerreras) {
		int contador = 0;
		for (int i = hormigas.size(); i < cantidadHormigasTotal; i++) {
			Hormiga hormiga = new Hormiga(id++);
			//observer
			hormiga.addPropertyChangeListener(this);
			//observer
			if (guerreras-- > 0) {
				hormiga.setGuerrera(true);
			}
			hormigas.add(hormiga);
			contador++;
		}
	}

	private boolean isTareaAcabada() {
		return tareaAcabada;
	}

	private void setTareaAcabada(boolean tareaAcabada) {
		this.tareaAcabada = tareaAcabada;
	}

	

}
