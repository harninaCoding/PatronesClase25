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
		grow(salary);
		aging();
		if(currentAge==adultAge&&developmentFactor<minimunDevelopmentFactor)
			setCurrentAge((int) (getLifeExpectancy()+1));
		return isAlive();
	}
	
	// Esto solo los menores
	public void grow(int salary) {
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
