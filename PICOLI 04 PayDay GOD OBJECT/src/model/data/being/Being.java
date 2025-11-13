package model.data.being;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import utiles.Utiles;

public class Being {
	private static final int maxLife = 120;
	private static final int minLife = 0;
	public static final int adultAge = 18;
	public static final int ancientAge = 65;
	private Behaviour behavior;
	private float lifeExpectancy;
	protected int currentAge = 0;
	protected static int vitalNecesity = 100;
	PropertyChangeSupport propertyAdultChangeSupport;
	PropertyChangeSupport propertyAncientChangeSupport;

	public Being(float lifeExpectancy) {
		super();
		this.lifeExpectancy = lifeExpectancy;
		setBehaviour();
		propertyAdultChangeSupport=new PropertyChangeSupport(this);
		propertyAncientChangeSupport=new PropertyChangeSupport(this);
	}

	
	
	public void addPropertyAdultChangeListener(PropertyChangeListener listener) {
		propertyAdultChangeSupport.addPropertyChangeListener(listener);
	}
	public void addPropertyAncientChangeListener(PropertyChangeListener listener) {
		propertyAncientChangeSupport.addPropertyChangeListener(listener);
	}



	public Being() {
		super();
		lifeExpectancy = calculateLifeExpectancy(minLife, maxLife);
		setBehaviour();
	}

	public float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	private int calculateLifeExpectancy(int minimun, int maximum) {
		return Utiles.dameNumero(maximum);
	}

	public int getCurrentAge() {
		return currentAge;
	}

	public void setCurrentAge(int currentAge) {
		this.currentAge = currentAge;
	}

	protected boolean aging() {
		if (isAlive())
			this.currentAge++;
		behavior=behavior.check();
		return isAlive();
	}

	public boolean isAlive() {
		return this.currentAge <= this.lifeExpectancy;
	}

	public boolean live(int salary) {
		return behavior.live(salary);
	}

	protected void recalculateLifeExpectancy(int salary) {
		float percentage = salary * 100 / this.vitalNecesity;
		float maxPercentage = 99;
		float minPercentage = 33;
		float minPeriod = 1f;
		if (percentage <= maxPercentage && percentage >= minPercentage) {
			this.lifeExpectancy -= minPeriod;
		} else if (percentage <= minPercentage) {
			float periodoMax = 2f;
			this.lifeExpectancy -= periodoMax;
		}
	}

	void feed(int salary) {
		recalculateLifeExpectancy(salary);
	}

	public boolean becomeOlder() {
		return isAlive() && currentAge == ancientAge;
	}

	boolean isAdultAge() {
		return currentAge==adultAge;
	}
	
	boolean isAncientAge() {
		return currentAge==ancientAge;
	}
	
	public boolean becomeAdult() {
		return isAlive() && currentAge == adultAge;
	}

	public int getVitalNecesity() {
		return behavior.getVitalNeeds();
	}

	public Behaviour getBehaviour() {
		return this.behavior;
	}
	private void setBehaviour() {
		behavior = new Young(this);
	}

}
