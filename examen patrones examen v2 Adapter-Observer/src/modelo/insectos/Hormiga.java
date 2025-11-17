package modelo.insectos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modelo.soporte.Alimento;

public class Hormiga {

	// observer
	PropertyChangeSupport pcs;
	// observer
	List<Alimento> alimentos;
	List<Integer> luchas;
	private final int maxima = 50;
	private int vida = new Random().nextInt(maxima) + 1;
	private int edad = 0;
	public long id;
	protected int incrementoVidaPorDefecto = 1;
	private boolean guerrera = false;

	public Hormiga(long id) {
		super();
		this.id = id;
		alimentos = new ArrayList();
		luchas = new ArrayList<>();
		// observer
		pcs = new PropertyChangeSupport(this);
		// observer
	}

	public boolean isGuerrera() {
		return guerrera;
	}

	public void setGuerrera(boolean guerrera) {
		this.guerrera = guerrera;
	}

	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void hacerTarea() {
		if (this.isAlive()) {
			if (guerrera) {
				incrementaEdad(vida / 4);
				int tiempoMaximoLucha = 100;
				luchas.add(new Random().nextInt(tiempoMaximoLucha));
			} else {
				incrementaEdad(incrementoVidaPorDefecto);
				alimentos.add(Alimento.getRandomAlimento());
			}
		} else {
			System.out.println(id + " mori por mi hormiguero");
			pcs.firePropertyChange("muerte", this, this);
		}
	};

	// observer
	// me apunto a tus avisos
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	//me desapunto a tus avisos
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	// observer

	public boolean isAlive() {
		return vida > edad;
	}

	protected void incrementaEdad(int i) {
		this.edad += i;
	}

}
