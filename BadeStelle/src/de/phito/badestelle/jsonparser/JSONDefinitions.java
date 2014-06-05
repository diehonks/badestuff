package de.phito.badestelle.jsonparser;

public class JSONDefinitions {
	public class BadeStellenJSON{
		public String badestellelink;
		public String badname;
		public String bezirk;
		public String coordinates;
		public String dat;
		public String eco;
		public String ente;
		public String farbe;
		public String id;
		public String profil;
		public String profillink;
		public String rss_name;
		public String sicht;
	}
	public class BadeStellenJSONContainer{
		public BadeStellenJSON[] index;
	}
}