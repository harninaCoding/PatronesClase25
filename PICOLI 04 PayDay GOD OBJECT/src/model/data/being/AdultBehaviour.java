package model.data.being;

import java.util.Optional;

public class AdultBehaviour implements Behaviour,CheckableBehaviour {
	Being being;
	private long savings;
	private boolean active;

	public AdultBehaviour(Being being) {
		super();
		this.being = being;
		savings=0;
		active=false;
	}
	@Override
	public Optional<CheckableBehaviour> getCheckable() {
		return Optional.of(this);
	}
	
	@Override
	public void checkChangeBehaviour() {
		if(being.becomeOlder()) {
			being.setBehaviour(new AncientBehaviour(being));
			being.promoteToAncient();
		}
	}
	@Override
	public void feed(int salary) {
		int total = 0;
		if (being.getCurrentAge() <being.ANCIENTAGE) {
			// sueldo es la cantidad
			int resto = salary - being.getVitalNecesity();
			// resto sera -20
			setSavings(getSavings()+resto);
			// ahorros -10
			if (getSavings() < 0) {
				total = (int) (being.getVitalNecesity() - getSavings());
				setSavings(0);
			}
		} else {
			total = salary;
		}
		being.recalculateLifeExpectancy(total);
	}
	public long getSavings() {
		return savings;
	}

	public void setSavings(long savings) {
		this.savings = savings;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

	
}
