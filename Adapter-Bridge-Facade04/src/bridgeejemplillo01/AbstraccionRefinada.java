package bridgeejemplillo01;

public class AbstraccionRefinada implements Abstraccion {
	private Cocinador cocinador;

	public AbstraccionRefinada(Cocinador cocin) {

		this.cocinador = cocin;
	}

	@Override
	public void preparar() {
		this.cocinador.cocinar();
	}

}
