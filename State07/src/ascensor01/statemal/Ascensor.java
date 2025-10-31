package ascensor01.statemal;

public class Ascensor {
	int plantaActual = 0;
	int plantaMaxima = 10;
	Comportamiento comportamiento;

	public Ascensor() {
		super();
		comportamiento = new ComportamientoAbajo();
	}

	private void setComportamiento() {
		if (plantaActual == 0) {
			comportamiento = new ComportamientoAbajo();
		} else if (plantaActual == plantaMaxima) {
			comportamiento = new comportamientoArriba();
		} else {
			comportamiento = new ComportamientoEntrePlanta();
		}
	}

	public boolean subir() {
		boolean subir = comportamiento.subir();
		compruebaCambio(subir);
		if(subir) plantaActual++;
		return subir;
	}

	public boolean bajar() {
		boolean bajar = comportamiento.bajar();
		compruebaCambio(bajar);
		if(bajar) plantaActual--;
		return bajar;
	}

	private void compruebaCambio(boolean cambio) {
		if (cambio) {
			setComportamiento();
		}
	}

}
