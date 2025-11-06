package model.data.being;

import java.util.Optional;

public class YoungBehaviour implements Behaviour, CheckableBehaviour {
	Being being;
	private float developmentFactor;
	private float rightDevelopmentFactor = 5.55f;
	private float minimunDevelopmentFactor = rightDevelopmentFactor * 10;

	public YoungBehaviour(Being being) {
		super();
		this.being = being;
	}

	@Override
	public Optional<CheckableBehaviour> getCheckable() {
		return Optional.of(this);
	}

	@Override
	public void checkChangeBehaviour() {
		if (being.becomeAdult()) {
			being.setBehaviour(new AdultBehaviour(being));
			// patron observer
			being.promoteToAdult();
			// patron observer
		}
	}

	@Override
	public void feed(int salary) {
		if (salary >= being.getVitalNecesity()) {
			// Crecimiento completo
			setDevelopmentFactor(getDevelopmentFactor() + getRightDevelopmentFactor());
		} else if (salary > 0) {
			// Crecimiento parcial
			double growthFactor = ((float) salary / being.getVitalNecesity()) * getRightDevelopmentFactor();
			setDevelopmentFactor((float) (getDevelopmentFactor() + growthFactor));
		}
		if (being.getCurrentAge() == being.ADULTAGE && developmentFactor < minimunDevelopmentFactor)
			being.setCurrentAge((int) (being.getLifeExpectancy() + 1));

	}

	public float getRightDevelopmentFactor() {
		return rightDevelopmentFactor;
	}

	public float getMinimunDevelopmentFactor() {
		return minimunDevelopmentFactor;
	}

	public float getDevelopmentFactor() {
		return developmentFactor;
	}

	public void setDevelopmentFactor(float developmentFactor) {
		this.developmentFactor = developmentFactor;
	}

}
