package modelo.insectos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import modelo.soporte.Alimento;
import modelo.strategy.Comportamiento;
import modelo.strategy.Guerrera;
import modelo.strategy.Recolectora;
import modelo.strategy.Rol;

public class Hormiga {
	// Strategy
	// La clase establece sus posibles comportamientos
	// que son cambiados desde fuera
	private Comportamiento recolectora = new Recolectora();
	private Comportamiento guerrera = new Guerrera();
	private Rol rol;
	private Comportamiento comportamiento = recolectora;
	// Strategy

	PropertyChangeSupport pcs;

	private final int maxima = 50;
	private int vida = new Random().nextInt(maxima) + 1;
	private int edad = 0;
	public long id;
	public int incrementoVidaPorDefecto = 1;

	public Hormiga(long id) {
		super();
		this.id = id;
		pcs = new PropertyChangeSupport(this);
		hazteRecolectora();
	}

	public void hacerTarea() {
		if (this.isAlive()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			comportamiento.hacerTarea(this);
		} else {
//			System.out.println(id+" mori por mi hormiguero");
			pcs.firePropertyChange("muerte", this, this);
		}
	};

	public void hazteGuerrera() {
		comportamiento = guerrera;
		rol = Rol.guerrera;
	}

	public void hazteRecolectora() {
		comportamiento = recolectora;
		rol=Rol.recolectora;
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

	public boolean isAlive() {
		return vida > edad;
	}

	public void incrementaEdad(int i) {
		this.edad += i;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	public Optional<List<Alimento>> getAlimentos() {
		return comportamiento.getAlimentos();
	}

	public boolean isGuerrera() {
		return rol==Rol.guerrera;
	}

}
