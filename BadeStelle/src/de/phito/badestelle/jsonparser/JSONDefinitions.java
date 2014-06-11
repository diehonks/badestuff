package de.phito.badestelle.jsonparser;

// TODO: Auto-generated Javadoc
/**
 * The Class JSONDefinitions used by the GSON library, to make the access to the JSON as easy as possible.
 */
public class JSONDefinitions {
	
	/**
	 * The Class BadeStellenJSON.
	 */
	public class BadeStellenJSON{
		
		/** The badestellelink. */
		public String badestellelink;
		
		/** The badname. */
		public String badname;
		
		/** The bezirk. */
		public String bezirk;
		
		/** The coordinates. */
		public String coordinates;
		
		/** The dat. */
		public String dat;
		
		/** The eco. */
		public String eco;
		
		/** The ente. */
		public String ente;
		
		/** The farbe. */
		public String farbe;
		
		/** The id. */
		public String id;
		
		/** The profil. */
		public String profil;
		
		/** The profillink. */
		public String profillink;
		
		/** The rss_name. */
		public String rss_name;
		
		/** The sicht. */
		public String sicht;
	}
	
	/**
	 * The Class BadeStellenJSONContainer is a wrapper for the JSON list items.
	 */
	public class BadeStellenJSONContainer{
		
		/** The index. */
		public BadeStellenJSON[] index;
	}
}