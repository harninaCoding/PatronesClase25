package ordenadorsolucion;

public class DiscoDuro extends Componente {
	private final String tipo;
	private final int capacidadGb;

	public DiscoDuro(Ordenador ordenador, String tipo, int capacidadGb, double coste) {
		super(ordenador, coste);
		this.tipo = tipo;
		this.capacidadGb = capacidadGb;
	}

	@Override
	public String description() {
		return super.description() + " + Disco "+tipo+": " +capacidadGb;
	}
}
