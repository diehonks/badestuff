package de.phito.badestelle.model;

public class Coordinates {
	public double latitude;
	public double longitude;
	
	public Coordinates(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public static Coordinates parseFromString(String coordString){
		String[] latLonStr = coordString.split(",");
		return new Coordinates(Double.valueOf(latLonStr[1]), Double.valueOf(latLonStr[0]));
	}
}
