package de.phito.badestelle.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import android.annotation.SuppressLint;
import android.graphics.Color;
import de.phito.badestelle.jsonparser.JSONDefinitions;

@SuppressLint("SimpleDateFormat")
public class BadeStelle {
	private Logger logger = Logger.getLogger(BadeStelle.class.getSimpleName());
	public final WikiLink link;
	public final String name;
	public final String district;
	public final Coordinates coordinates;
	public Date lastUpdate;
	public int statusColor;
	public final int enterokokkenPerDeciLiter;
	public int ecoliPerDeciLiter;
	public final int viewDepthCM;
	public int id;

	public BadeStelle(JSONDefinitions.BadeStellenJSON json){
		this.link =  WikiLink.parseFromString(json.badestellelink);
		this.name = json.badname;
		this.district = json.bezirk;
		this.coordinates = Coordinates.parseFromString(json.coordinates);
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			this.lastUpdate = formatter.parse(json.dat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warning("unable to parse Date!");
			this.lastUpdate = null;
		}
		if(json.farbe.startsWith("gruen")){
			statusColor = Color.GREEN;
		} else if(json.farbe.startsWith("gelb")){
			statusColor = Color.YELLOW;
		} else if(json.farbe.startsWith("rot")){
			statusColor = Color.RED;
		} else {			
			statusColor = Color.WHITE;;
		}
		if(json.ente.startsWith("<")){
			enterokokkenPerDeciLiter = 0;
		} else if(json.ente.length() == 0){
			enterokokkenPerDeciLiter = -1; // n/a
		} else {
			enterokokkenPerDeciLiter = Integer.valueOf(json.ente);
		}
		if(json.eco.startsWith("<")){
			ecoliPerDeciLiter = 0;
		} else if(json.eco.length() == 0){
			ecoliPerDeciLiter = -1; // n/a
		} else {
			ecoliPerDeciLiter = Integer.valueOf(json.eco);
		}
		if(json.sicht.length() == 0){
			this.viewDepthCM = -1; // n/a
		} else {
			if(json.sicht.startsWith(">") || json.sicht.startsWith("<")){
				this.viewDepthCM = Integer.valueOf(json.sicht.substring(1));
			} else {
				this.viewDepthCM = Integer.valueOf(json.sicht);
			}
		}
		this.id = Integer.valueOf(json.id);
		
	}	
	
}
