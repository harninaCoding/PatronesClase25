package model.data.being;

import java.util.Optional;

public interface Behaviour {
	public void feed(int salary);
	public Optional<CheckableBehaviour> getCheckable();
}
