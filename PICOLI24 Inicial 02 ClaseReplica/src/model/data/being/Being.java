package model.data.being;

import utiles.Utiles;

public class Being {
	private static final int maxLife = 120;
	private static final int minLife = 0;
	public static final int ADULTAGE = 18;
	public static final int ANCIENTAGE= 65;

	private float lifeExpectancy;
	protected int currentAge = 0;
	protected static int vitalNecesity = 100;
	Behaviour behaviour;

	public Being(float lifeExpectancy) {
		super();
		this.lifeExpectancy = lifeExpectancy;
	}

	public Being() {
		super();
		lifeExpectancy = calculateLifeExpectancy(minLife, maxLife);
	}

	public Being(Being ser) {
		this.currentAge = ser.currentAge;
		this.lifeExpectancy = ser.lifeExpectancy;
		this.vitalNecesity = ser.vitalNecesity;
		this.behaviour=ser.getBehaviour();
	}
	
	public Behaviour getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(Behaviour behaviour) {
		this.behaviour = behaviour;
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

	protected void aging() {
		this.currentAge++;
	}

	public boolean isAlive() {
		return this.currentAge <= this.lifeExpectancy;
	}

	public boolean live(int salary) {
		behaviour.feed(salary);
		this.aging();
		return isAlive();
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



	public boolean becomeOlder() {
		return isAlive() && currentAge == ANCIENTAGE;
	}

	public boolean becomeAdult() {
		return isAlive() && currentAge == ADULTAGE;
	}

	public int getVitalNecesity() {
		return vitalNecesity;
	}
}
