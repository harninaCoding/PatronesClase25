package model.data.being;

import utiles.Utiles;

public class Being {
	private static final int maxLife = 120;
	private static final int minLife = 0;
	public static final int adultAge = 18;
	public static final int ancientAge= 65;

	private float lifeExpectancy;
	protected int currentAge = 0;
	protected static int vitalNecesity = 100;

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
		// TODO tengo que ver si un menor pasa a ser adulto o no
		// y para que pase de adulto a anciano
		return isAlive();
	}

	public boolean isAlive() {
		return this.currentAge <= this.lifeExpectancy;
	}

	public boolean live(int salary) {
		this.feed(salary);
		return this.aging();
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

	private void feed(int salary) {
		recalculateLifeExpectancy(salary);
	}

	public boolean becomeOlder() {
		return isAlive() && currentAge == ancientAge;
	}

	public boolean becomeAdult() {
		return isAlive() && currentAge == adultAge;
	}

	public int getVitalNecesity() {
		return vitalNecesity;
	}
}
