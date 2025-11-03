package model.data.being;

public class Adult extends Being {
	private long savings;
	private boolean active;

	public Adult(Being being) {
		super(being);
		savings=0;
		active=false;
	}

	// Esto solo los adultos
	// nv 100
	// ahorros 10
	// sueldo 80
	@Override
	public void feed(int amount) {
		int total = 0;
		if (currentAge < ancientAge) {
			// sueldo es la cantidad
			int resto = amount - vitalNecesity;
			// resto sera -20
			this.savings += resto;
			// ahorros -10
			if (savings < 0) {
				total = (int) (vitalNecesity - savings);
				this.savings = 0;
			}
		} else {
			total = amount;
		}
		recalculateLifeExpectancy(total);
	}

}
