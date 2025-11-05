package model.data.being;

public class ControlBeing {

	public static Being createBeing() {
		return new Young();
	}

	public static Being createBeing(int lifeExpentancy) {
		return new Young(lifeExpentancy);
	}

	public static Being controlAges(Being being) {
		if (being.getCurrentAge() == being.adultAge)
			return new Adult(being);
		if (being.getCurrentAge() == being.ancientAge)
			return new Being(being);
		return being;
	}
}
