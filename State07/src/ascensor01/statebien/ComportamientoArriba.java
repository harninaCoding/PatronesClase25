package ascensor01.statebien;

public class ComportamientoArriba implements Comportamiento {

	Ascensor ascensor;
	
	public ComportamientoArriba(Ascensor ascensor) {
		super();
		this.ascensor = ascensor;
	}

	@Override
	public boolean subir() {
		System.out.println("no puedo subir mas C.Arriba");
		return false;
	}

	@Override
	public boolean bajar() {
		System.out.println("bajando C.arrriba");
		ascensor.setComportamiento(new ComportamientoEntrePlanta(ascensor));
		return true;
	}

}
