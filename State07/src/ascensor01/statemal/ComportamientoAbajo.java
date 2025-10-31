package ascensor01.statemal;

public class ComportamientoAbajo implements Comportamiento {

	@Override
	public boolean subir() {
		System.out.println("subiendo");
		return true;
	}

	@Override
	public boolean bajar() {
		System.out.println("no puedo bajar mas");
		return false;
	}

}
