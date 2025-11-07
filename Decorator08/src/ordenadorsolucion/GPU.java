package ordenadorsolucion;

public class GPU extends Componente {
	private final TipoGPU tipo;

	public GPU(Ordenador ordenador, double coste, TipoGPU tipo) {
		super(ordenador, coste);
		this.tipo = tipo;
	}

	@Override
	public String description() {
		return super.description() + " GPU " + tipo;
	}

}
