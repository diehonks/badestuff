package de.phito.badestelle.listview;

// TODO: Auto-generated Javadoc
/**
 * The Class ListItemData.
 */
public class ListItemData {
	
	/** The id. */
	public int id;
	
	/** The title. */
	public String title;
	
	/** The color. */
	public int color;
	
	/**
	 * Instantiates a new list item data.
	 *
	 * @param id the id
	 * @param name the name
	 * @param statusColor the status color
	 */
	public ListItemData(int id, String name, int statusColor) {
		this.id = id;
		this.title = name;
		this.color = statusColor;
	}
}
