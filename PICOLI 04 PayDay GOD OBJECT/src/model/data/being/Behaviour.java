package model.data.being;

public interface Behaviour {
	public boolean live(int salary);
	public Behaviour check();
	public int getVitalNeeds();
}
