package problemaobserverFacilito;

public class GeographicalPoint {

	private final double latitude;
	private final double longitude;
	private final double altitude;

	public GeographicalPoint(double latitude, double longitud, double altitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitud;
		this.altitude = altitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitud() {
		return longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	@Override
	public String toString() {
		return "latitude "+latitude+" longitude "+longitude+" altitude "+altitude;
	}
}
