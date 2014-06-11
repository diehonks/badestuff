package de.phito.badestelle.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import android.annotation.SuppressLint;
import android.graphics.Color;
import de.phito.badestelle.jsonparser.JSONDefinitions;

/**
 * The Class BadeStelle contains all the data from one lake.
 */
@SuppressLint("SimpleDateFormat")
public class BadeStelle {
	
	/** The logger. */
	private Logger logger = Logger.getLogger(BadeStelle.class.getSimpleName());
	
	/** The link. */
	public final WikiLink link;
	
	/** The name. */
	public final String name;
	
	/** The district. */
	public final String district;
	
	/** The coordinates. */
	public final Coordinates coordinates;
	
	/** The last update. */
	public Date lastUpdate;
	
	/** The status color. */
	public int statusColor;
	
	/** The enterokokken per deci liter. */
	public final int enterokokkenPerDeciLiter;
	
	/** The ecoli per deci liter. */
	public int ecoliPerDeciLiter;
	
	/** The view depth cm. */
	public final int viewDepthCM;
	
	/** The id. */
	public int id;

	/**
	 * Instantiates a new bade stelle.
	 *
	 * @param json the json
	 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result
				+ ((district == null) ? 0 : district.hashCode());
		result = prime * result + ecoliPerDeciLiter;
		result = prime * result + enterokokkenPerDeciLiter;
		result = prime * result + id;
		result = prime * result
				+ ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + statusColor;
		result = prime * result + viewDepthCM;
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
		BadeStelle other = (BadeStelle) obj;
		if (coordinates == null) {
			if (other.coordinates != null)
				return false;
		} else if (!coordinates.equals(other.coordinates))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (ecoliPerDeciLiter != other.ecoliPerDeciLiter)
			return false;
		if (enterokokkenPerDeciLiter != other.enterokokkenPerDeciLiter)
			return false;
		if (id != other.id)
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (statusColor != other.statusColor)
			return false;
		if (viewDepthCM != other.viewDepthCM)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BadeStelle [link=" + link + ", name=" + name + ", district="
				+ district + ", coordinates=" + coordinates + ", lastUpdate="
				+ lastUpdate + ", statusColor=" + statusColor
				+ ", enterokokkenPerDeciLiter=" + enterokokkenPerDeciLiter
				+ ", ecoliPerDeciLiter=" + ecoliPerDeciLiter + ", viewDepthCM="
				+ viewDepthCM + ", id=" + id + "]";
	}	
}
