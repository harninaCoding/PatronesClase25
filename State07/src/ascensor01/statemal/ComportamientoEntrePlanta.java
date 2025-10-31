package ascensor01.statemal;

public class ComportamientoEntrePlanta implements Comportamiento {

	@Override
	public boolean subir() {
		System.out.println("subiendo");
		return true;
	}

	@Override
	public boolean bajar() {
		System.out.println("bajando");
		return true;
	}

}
