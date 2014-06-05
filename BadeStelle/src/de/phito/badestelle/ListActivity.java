package de.phito.badestelle;

import java.util.List;

import de.phito.badestelle.listview.ArrayAdapterItem;
import de.phito.badestelle.listview.ListItemData;
import de.phito.badestelle.model.BadeStelle;
import de.phito.badestelle.model.BadeStellenContainer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends Activity {

	private BadeStellenContainer badeStellen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		badeStellen = BadeStellenContainer.getInstance();
		badeStellen.loadBadeStellenJSON(getApplicationContext());
		
		List<BadeStelle> badeStellenList = badeStellen.getBadestellen();
		ListItemData[] listItems = new ListItemData[badeStellenList.size()];
		for(int i=0; i<badeStellenList.size(); i++){
			BadeStelle bs = badeStellenList.get(i);
			listItems[i] = new ListItemData(bs.id, bs.name, bs.statusColor);
		}
		
		ListView badeSeeList = (ListView) findViewById(R.id.listBadeSeen);
		ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.listview_badesee_item, listItems);
		badeSeeList.setAdapter(adapter);
		badeSeeList.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Context context = view.getContext();
				TextView textView = (TextView) view.findViewById(R.id.listitem_texttitle);
				Integer itemid = (Integer) textView.getTag();
				Toast.makeText(context, "Item ID: " + itemid, Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getBaseContext(), DetailActivity.class);
				intent.putExtra(DetailActivity.SHOW_DETAIL_ID, itemid);
				startActivity(intent);
			};
		}
		);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

}
