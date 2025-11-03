package model.data.being;

public class YoungBehaviour implements Behaviour {
	Young being;

	
	public YoungBehaviour(Young being) {
		super();
		this.being = being;
	}


	@Override
	public void feed(int salary) {
		  if (salary >= being.getVitalNecesity()) {
	            // Crecimiento completo
	            being.setDevelopmentFactor(being.getDevelopmentFactor()+ being.getRightDevelopmentFactor());
	        } else if (salary > 0) {
	            // Crecimiento parcial
	            double growthFactor = ((float)salary / being.getVitalNecesity()) * being.getRightDevelopmentFactor();
	            being.setDevelopmentFactor((float) (being.getDevelopmentFactor()+ growthFactor));
	        }

	}

}
