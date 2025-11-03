package ascensor01.statebien;

public class Ascensor {
	int plantaActual = 0;
	int plantaMaxima = 10;
	Comportamiento comportamiento;

	public Ascensor() {
		super();
		comportamiento = new ComportamientoAbajo(this);
	}

	public void subir() {
		if(comportamiento.subir())plantaActual++;
	}

	public void bajar() {
		if(comportamiento.bajar()) plantaActual--;
	}

	public void setComportamiento(Comportamiento comportamiento) {
		this.comportamiento=comportamiento;
	}
	
	public boolean isPlantaCero() {
		return this.plantaActual==0;
	}

	public boolean isPlantaMaxima() {
		return this.plantaActual==plantaMaxima;
	}
}
