package ordenadorsolucion;

public class OrdenadorBase implements Ordenador {
	private final double baseCost;

	public OrdenadorBase(double baseCost) {
		this.baseCost = baseCost;
	}

	@Override
	public double calculateCost() {
		return baseCost;
	}

	@Override
	public String description() {
		return "Ordenador base";
	}
}
