package model.data.being;

public class BeingBehaviour implements Behaviour {
	Being being;
	

	public BeingBehaviour(Being being) {
		super();
		this.being = being;
	}


	@Override
	public void feed(int salary) {
		being.recalculateLifeExpectancy(salary);

	}

}
