package model.data.being;

public class Ancient implements Behaviour {
	
	private Being being;
	

	public Ancient(Being being) {
		super();
		this.being = being;
	}


	@Override
	public boolean live(int salary) {
		being.feed(salary);
		return being.aging();
	}


	@Override
	public Behaviour check() {
		return this;
	}


	@Override
	public int getVitalNeeds() {
		return Being.vitalNecesity/2;
	}
}
