package ordenadorsolucion;

public class Procesador extends Componente {
	private final String modelo;

	public Procesador(Ordenador ordenador, String modelo, double coste) {
		super(ordenador, coste);
		this.modelo = modelo;
	}

	@Override
	public String description() {
		return super.description() + " + CPU " + modelo;
	}
}
