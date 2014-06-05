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
}
