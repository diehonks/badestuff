package de.phito.badestelle.listview;

/**
 * The Class ListItemData contains all the data needed for one listitem to be displayed.
 */
public class ListItemData {
	
	/** The id as given in the json file. */
	public int id;
	
	/** The title of the list item. */
	public String title;
	
	/** The color of the quality indicator. */
	public int color;
	
	/**
	 * Instantiates a new list item data.
	 *
	 * @param id the id as given in the json file
	 * @param name the name of the lake
	 * @param statusColor the status color as used by the quality indicator
	 */
	public ListItemData(int id, String name, int statusColor) {
		this.id = id;
		this.title = name;
		this.color = statusColor;
	}
}
