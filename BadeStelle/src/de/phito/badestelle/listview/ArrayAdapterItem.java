package de.phito.badestelle.listview;

import de.phito.badestelle.R;
import de.phito.badestelle.views.QualityIndicator;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ArrayAdapterItem extends ArrayAdapter<ListItemData> {
	 
    Context mContext;
    int layoutResourceId;
    ListItemData data[] = null;
 
    public ArrayAdapterItem(Context mContext, int layoutResourceId, ListItemData[] data) {
 
        super(mContext, layoutResourceId, data);
 
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }
        ListItemData listItemData = data[position];

        TextView textViewItem = (TextView) convertView.findViewById(R.id.listitem_texttitle);
        // save item id as tag in title
        textViewItem.setTag(listItemData.id);
        textViewItem.setText(listItemData.title);
        QualityIndicator qualityIndicator = (QualityIndicator) convertView.findViewById(R.id.listitem_quality);
        qualityIndicator.setColor(listItemData.color);
 
        return convertView;
 
    }
 
}