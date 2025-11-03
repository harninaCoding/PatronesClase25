package model.data.being;

public class ControlBeing {

	public static Being createBeing() {
		return new Young();
	}

	public static Being createBeing(int lifeExpentancy) {
		return new Young(lifeExpentancy);
	}

	public static Being controlAges(Being being) {
		if (being.getCurrentAge() == being.ADULTAGE)
			return new Adult(being);
		if (being.getCurrentAge() == being.ANCIENTAGE)
			return new Being(being);
		return being;
	}
}
