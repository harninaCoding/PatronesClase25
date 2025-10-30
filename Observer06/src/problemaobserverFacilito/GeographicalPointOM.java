package problemaobserverFacilito;

import java.util.Random;

public class GeographicalPointOM {
	private static double maximumDelta=1;
	private static Random random=new Random();
	
	
	public GeographicalPoint getGeographicalPointRelated(GeographicalPoint geographicalPoint) {
		return new GeographicalPoint(
				applyDelta(geographicalPoint.getLatitude()),
						applyDelta(geographicalPoint.getLongitud()),
								applyDelta(geographicalPoint.getAltitude()));
	}
	
	private double applyDelta(double spec) {
			return spec+getRandomDelta();
	}
	
	private double getRandomDelta() {
		return random.nextDouble()*maximumDelta;
	}
}
