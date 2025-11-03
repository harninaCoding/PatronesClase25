package ascensor01.statebien;

public class ComportamientoAbajo implements Comportamiento {
	Ascensor ascensor;

	public ComportamientoAbajo(Ascensor ascensor) {
		super();
		this.ascensor = ascensor;
	}


	@Override
	public boolean subir() {
		System.out.println("subiendo C.abajo");
		ascensor.setComportamiento(new ComportamientoEntrePlanta(ascensor));
		return true;
	}

	@Override
	public boolean bajar() {
		System.out.println("no puedo bajar mas C.abajo");
		return false;
	}

}
