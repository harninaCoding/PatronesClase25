package ascensor01.statebien;

public class ComportamientoEntrePlanta implements Comportamiento {
	Ascensor ascensor;

	public ComportamientoEntrePlanta(Ascensor ascensor) {
		super();
		this.ascensor = ascensor;
	}

	@Override
	public boolean subir() {
		System.out.println("subiendo C.Entre");
		if(ascensor.isPlantaMaxima()) ascensor.setComportamiento(new ComportamientoArriba(ascensor));
		return true;
	}

	@Override
	public boolean bajar() {
		System.out.println("bajando C.entre");
		if(ascensor.isPlantaCero()) ascensor.setComportamiento(new ComportamientoAbajo(ascensor));
		return true;
	}

}
