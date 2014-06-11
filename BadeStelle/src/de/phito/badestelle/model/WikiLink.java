package de.phito.badestelle.model;


// TODO: Auto-generated Javadoc
/**
 * The Class WikiLink.
 */
public class WikiLink{
	
	/** The url. */
	public final String url;
	
	/** The title. */
	
	public final String title;
	/**
	 * Instantiates a new wiki link.
	 *
	 * @param url the url
	 * @param title the title
	 */
	public WikiLink(String url, String title) {
		this.url = "http://www.berlin.de" + url;
		this.title = title;
	}
	
	/**
	 * Parses the from string.
     *
	 * links are in this wiki format
	 * "[[/badegewaesser/badestellen/alterhof.html|Alter Hof]]"
	 * but we need them as full http addresses and their titles
	 * e.g. link: http://www.berlin.de/badegewaesser/badestellen/alterhof.html
	 * title: Alter Hof
	 *
	 * @param wikiLink the wiki link
	 * @return the wiki link
	 */
	public static WikiLink parseFromString(String wikiLink){

		String[] linkTitle = wikiLink.split("\\|");
		return new WikiLink(linkTitle[0].substring(2), linkTitle[1].substring(0, linkTitle[1].length()));
	}
}
