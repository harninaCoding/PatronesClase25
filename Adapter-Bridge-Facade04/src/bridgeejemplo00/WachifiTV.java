package bridgeejemplo00;

public class WachifiTV implements IModeloTV {

	@Override
	public void encender() {
		System.out.println("emito la frecuencia encender wachifi");

	}

	@Override
	public void apagar() {
		System.out.println("emito la frecuencia apagar wachifi");

	}

}
