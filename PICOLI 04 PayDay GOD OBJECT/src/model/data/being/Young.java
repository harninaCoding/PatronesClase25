package model.data.being;

public class Young implements Behaviour {
	private float developmentFactor;
	private float rightDevelopmentFactor=5.55f;
	private float minimunDevelopmentFactor=rightDevelopmentFactor*10;
	private Being being;
	
	public Young(Being being) {
		super();
		this.being=being;
	}

	@Override
	public boolean live(int salary) {
		grow(salary);
		being.aging();
		if(being.getCurrentAge()==being.adultAge&&developmentFactor<minimunDevelopmentFactor)
			being.setCurrentAge((int) (being.getLifeExpectancy()+1));
		return being.isAlive();
	}
	
	// Esto solo los menores
	public void grow(int salary) {
		   if (salary >= being.getVitalNecesity()) {
	            // Crecimiento completo
	            developmentFactor += rightDevelopmentFactor;
	        } else if (salary > 0) {
	            // Crecimiento parcial
	            double growthFactor = ((float)salary / being.getVitalNecesity()) * rightDevelopmentFactor;
	            developmentFactor += growthFactor;
	        }
	}

	public float getDevelopmentFactor() {
		return developmentFactor;
	}

	public void setDevelopmentFactor(float developmentFactor) {
		this.developmentFactor = developmentFactor;
	}

	@Override
	public Behaviour check() {
		if(being.isAdultAge()) {
			being.propertyAdultChangeSupport.firePropertyChange("adult", null, being);
			return new Adult(being);
		}
		return this;
	}

	@Override
	public int getVitalNeeds() {
		return Being.vitalNecesity;
	}
}
