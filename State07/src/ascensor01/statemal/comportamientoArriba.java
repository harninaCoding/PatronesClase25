package ascensor01.statemal;

public class comportamientoArriba implements Comportamiento {

	@Override
	public boolean subir() {
		System.out.println("no puedo subir mas");
		return false;
	}

	@Override
	public boolean bajar() {
		System.out.println("bajando");
		return true;
	}

}
