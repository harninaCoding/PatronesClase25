package model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public enum Polar {
	North, East, South, West;
	
	public static List<Polar> getLeftPolar(Set<Polar> drawnPolar) {
		return Arrays.asList(Polar.values()).stream()
			.filter((polar) -> {
						return !drawnPolar.contains(polar);
					})
			.collect(Collectors.toList());
	}
	public static Polar getOppositePolar(Polar polarEnum) {
		List<Polar> asList = Arrays.asList(Polar.values());
		int index = (asList.indexOf(polarEnum)+2)%4;
		return asList.get(index);
	}
	public static Polar GetRandomLeftPolar(Set<Polar> Polars) {
		return Polar.getRandomPolar(Polar.getLeftPolar(Polars));
	}
	private static Polar getRandomPolar(List<Polar> polars) {
		return polars.get(new Random().nextInt(polars.size()));
	}
	public static Polar getRandomPolar() {
		Polar[] values = Polar.values();
		return values[new Random().nextInt(values.length)];
	}
}
