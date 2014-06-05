package de.phito.badestelle.model;


class WikiLink{
	String url;
	String title;
	
	public WikiLink(String url, String title) {
		this.url = "http://www.berlin.de" + url;
		this.title = title;
	}
	
	public static WikiLink parseFromString(String wikiLink){
		// links are in this wiki format
		// "[[/badegewaesser/badestellen/alterhof.html|Alter Hof]]"
		// but we need them as full http addresses and their titles
		// e.g. link: http://www.berlin.de/badegewaesser/badestellen/alterhof.html
		//		title: Alter Hof
		String[] linkTitle = wikiLink.split("\\|");
		return new WikiLink(linkTitle[0].substring(2), linkTitle[1].substring(0, linkTitle[1].length()));
	}
}
