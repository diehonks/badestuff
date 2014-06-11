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

// TODO: Auto-generated Javadoc
/**
 * The Class ArrayAdapterItem.
 */
public class BadeStellenListAdapter extends ArrayAdapter<ListItemData> {
	 
    /** The m context. */
    Context mContext;
    
    /** The layout resource id. */
    int layoutResourceId;
    
    /** The data. */
    ListItemData data[] = null;
 
    /**
     * Instantiates a new array adapter item.
     *
     * @param mContext the m context
     * @param layoutResourceId the layout resource id
     * @param data the data
     */
    public BadeStellenListAdapter(Context mContext, int layoutResourceId, ListItemData[] data) {
 
        super(mContext, layoutResourceId, data);
 
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }
 
    /* (non-Javadoc)
     * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         if(convertView==null){
            // inflate the layout if it wasn't already initialized
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }
        ListItemData listItemData = data[position];

        TextView textViewItem = (TextView) convertView.findViewById(R.id.listitem_texttitle);
        // save item id as tag in title
        textViewItem.setTag(listItemData.id);
        textViewItem.setText(listItemData.title);
        
        // create quality indicator to display the quality of the lake in the list view as colored circle
        QualityIndicator qualityIndicator = (QualityIndicator) convertView.findViewById(R.id.listitem_quality);
        qualityIndicator.setColor(listItemData.color);
 
        return convertView;
 
    }
 
}