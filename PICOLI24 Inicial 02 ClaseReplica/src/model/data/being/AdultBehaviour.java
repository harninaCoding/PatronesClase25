package model.data.being;

public class AdultBehaviour implements Behaviour {
	Adult being;

	public AdultBehaviour(Adult being) {
		super();
		this.being = being;
	}

	@Override
	public void feed(int salary) {
		int total = 0;
		if (being.getCurrentAge() <being.ANCIENTAGE) {
			// sueldo es la cantidad
			int resto = salary - being.getVitalNecesity();
			// resto sera -20
			being.setSavings(being.getSavings()+resto);
			// ahorros -10
			if (being.getSavings() < 0) {
				total = (int) (being.getVitalNecesity() - being.getSavings());
				being.setSavings(0);
			}
		} else {
			total = salary;
		}
		being.recalculateLifeExpectancy(total);
	}

}
