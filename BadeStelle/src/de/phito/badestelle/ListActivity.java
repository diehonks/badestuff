package de.phito.badestelle;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import de.phito.badestelle.listview.BadeStellenListAdapter;
import de.phito.badestelle.listview.ListItemData;
import de.phito.badestelle.model.BadeStelle;
import de.phito.badestelle.model.BadeStellenContainer;

/**
 * The Class ListActivity is the main activity used to select one lake from a list.
 */
public class ListActivity extends Activity {

	/** The bade stellen container, which is able to load and parse the JSON. */
	private BadeStellenContainer badeStellen;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		// load badestellen from file
		badeStellen = BadeStellenContainer.getInstance();
		badeStellen.loadBadeStellenJSON(getApplicationContext());
		
		// create model list items that can later be used to fill the inflated views with data
		List<BadeStelle> badeStellenList = badeStellen.getBadestellen();
		ListItemData[] listItems = new ListItemData[badeStellenList.size()];
		for(int i=0; i<badeStellenList.size(); i++){
			BadeStelle bs = badeStellenList.get(i);
			listItems[i] = new ListItemData(bs.id, bs.name, bs.statusColor);
		}
		BadeStellenListAdapter adapter = new BadeStellenListAdapter(this, R.layout.listview_badesee_item, listItems);
		
		// set model for list view and use the tag of the list items to create a simple on click listener 
		ListView badeSeeList = (ListView) findViewById(R.id.listBadeSeen);
		badeSeeList.setAdapter(adapter);
		badeSeeList.setOnItemClickListener(new OnItemClickListener(){
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					TextView textView = (TextView) view.findViewById(R.id.listitem_texttitle);
					Integer itemid = (Integer) textView.getTag();
					Intent intent = new Intent(getBaseContext(), DetailActivity.class);
					intent.putExtra(DetailActivity.SHOW_DETAIL_ID, itemid);
					startActivity(intent);
				};
			}
		);
		
	}
}
