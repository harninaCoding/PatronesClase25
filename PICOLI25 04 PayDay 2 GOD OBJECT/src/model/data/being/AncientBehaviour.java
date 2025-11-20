package model.data.being;

import java.util.Optional;

import model.data.goverment.Government;

public class AncientBehaviour implements Behaviour {
	Being being;

	public AncientBehaviour(Being being) {
		super();
		this.being = being;
	}

	@Override
	public void feed(int salary) {
		being.recalculateLifeExpectancy(salary);
	}

		@Override
	public Optional<CheckableBehaviour> getCheckable() {
		return Optional.empty();
	}
	
}
