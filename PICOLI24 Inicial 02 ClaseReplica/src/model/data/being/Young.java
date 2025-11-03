package model.data.being;

public class Young extends Being {
	private float developmentFactor;
	private float rightDevelopmentFactor=5.55f;
	public float getRightDevelopmentFactor() {
		return rightDevelopmentFactor;
	}

	public float getMinimunDevelopmentFactor() {
		return minimunDevelopmentFactor;
	}

	private float minimunDevelopmentFactor=rightDevelopmentFactor*10;
	
	public Young(float lifeExpectancy) {
		super(lifeExpectancy);
	}
	
	public Young() {
		super();
	}

	@Override
	public boolean live(int salary) {
		boolean live = super.live(salary);
		if(currentAge==adultAge&&developmentFactor<minimunDevelopmentFactor)
			setCurrentAge((int) (getLifeExpectancy()+1));
		return live;
	}

	public float getDevelopmentFactor() {
		return developmentFactor;
	}

	public void setDevelopmentFactor(float developmentFactor) {
		this.developmentFactor = developmentFactor;
	}
}
