package de.phito.badestelle.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Coordinates.
 */
public class Coordinates {
	
	/** The latitude. */
	public double latitude;
	
	/** The longitude. */
	public double longitude;
	
	/**
	 * Instantiates a new coordinates.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 */
	public Coordinates(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * Parses the coordinates from string.
	 *
	 * @param coordString the coord string
	 * @return the coordinates
	 */
	public static Coordinates parseFromString(String coordString){
		String[] latLonStr = coordString.split(",");
		return new Coordinates(Double.valueOf(latLonStr[1]), Double.valueOf(latLonStr[0]));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinates [latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}
}
