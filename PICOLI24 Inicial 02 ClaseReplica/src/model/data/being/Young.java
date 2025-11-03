package model.data.being;

public class Young extends Being {
	private float developmentFactor;
	private float rightDevelopmentFactor=5.55f;
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
	
	// Esto solo los menores
	@Override
	public void feed(int salary) {
		   if (salary >= getVitalNecesity()) {
	            // Crecimiento completo
	            developmentFactor += rightDevelopmentFactor;
	        } else if (salary > 0) {
	            // Crecimiento parcial
	            double growthFactor = ((float)salary / getVitalNecesity()) * rightDevelopmentFactor;
	            developmentFactor += growthFactor;
	        }
	}

	public float getDevelopmentFactor() {
		return developmentFactor;
	}

	public void setDevelopmentFactor(float developmentFactor) {
		this.developmentFactor = developmentFactor;
	}
}
