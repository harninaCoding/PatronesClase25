package ordenadorsolucion;

// Decorador base: envuelve a un Ordenador y delega
public abstract class Componente implements Ordenador {
	protected final Ordenador ordenador;
	private final double coste;

	protected Componente(Ordenador ordenador, double coste) {
		super();
		this.ordenador = ordenador;
		this.coste = coste;
	}

	@Override
	public double calculateCost() {
		return ordenador.calculateCost()+coste;
	}

	@Override
	public String description() {
		return ordenador.description();
	}
}
