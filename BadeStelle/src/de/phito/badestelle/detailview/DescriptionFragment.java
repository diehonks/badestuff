package de.phito.badestelle.detailview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import de.phito.badestelle.R;

// TODO: Auto-generated Javadoc
/**
 * The Class DescriptionFragment creates a view for all the information about the lake
 */
public class DescriptionFragment extends Fragment {
		
		/** The Constant used in the Bundle BADE_STELLEN_NAME. */
		public static final String BADE_STELLEN_NAME = "BADE_STELLEN_NAME";
		
		/** The Constant used in the Bundle BADE_STELLEN_WIKI_LINK. */
		public static final String BADE_STELLEN_WIKI_LINK = "BADE_STELLEN_WIKI_LINK";
		
		/** The Constant used in the Bundle BADE_STELLEN_BEZIRK. */
		public static final String BADE_STELLEN_BEZIRK = "BADE_STELLEN_BEZIRK";
		
		/** The Constant used in the Bundle BADE_STELLEN_SICHTWEITE. */
		public static final String BADE_STELLEN_SICHTWEITE = "BADE_STELLEN_SICHTWEITE";
		
		/** The Constant used in the Bundle BADE_STELLEN_ECOLI. */
		public static final String BADE_STELLEN_ECOLI = "BADE_STELLEN_ECOLI";
		
		/** The Constant used in the Bundle BADE_STELLEN_ENTEROKOKKEN. */
		public static final String BADE_STELLEN_ENTEROKOKKEN= "BADE_STELLEN_ENTEROKOKKEN";
		
		/** The Constant used in the Bundle BADE_STELLEN_DATUM. */
		public static final String BADE_STELLEN_DATUM = "BADE_STELLEN_DATUM";

		/**
		 * Instantiates a new description fragment.
		 */
		public DescriptionFragment() {
			
		}

		/* (non-Javadoc)
		 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
		 */
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_detail_description, container, false);
			
			// set all the text information from the bundle into the layout
			TextView locationName = (TextView) rootView.findViewById(R.id.textLocationName);
			locationName.setText(getArguments().getString(BADE_STELLEN_NAME));
			
			TextView districtName = (TextView) rootView.findViewById(R.id.textBezirk);
			districtName.setText(getArguments().getString(BADE_STELLEN_BEZIRK));
			
			TextView sichtweite = (TextView) rootView.findViewById(R.id.textSichtweite);
			int sichtweiteValue = getArguments().getInt(BADE_STELLEN_SICHTWEITE);
			if(sichtweiteValue == -1){
				// -1 means that the value was not available in the source data
				sichtweite.setText(getResources().getString(R.string.value_not_available));
			} else {
				sichtweite.setText(Integer.toString(sichtweiteValue)+" cm");
			}
			
			TextView ecoli = (TextView) rootView.findViewById(R.id.textEcoli);
			int ecolivalue = getArguments().getInt(BADE_STELLEN_ECOLI);
			if(ecolivalue == -1){
				// -1 means that the value was not available in the source data
				ecoli.setText(getResources().getString(R.string.value_not_available));
			} else {
				ecoli.setText(Integer.toString(ecolivalue)+" / 100 ml");
			}
			
			TextView enterokokken = (TextView) rootView.findViewById(R.id.textEnterokokken);
			int enterokokkenValue = getArguments().getInt(BADE_STELLEN_ENTEROKOKKEN);
			if(enterokokkenValue == -1){
				// -1 means that the value was not available in the source data
				enterokokken.setText(getResources().getString(R.string.value_not_available));
			} else {
				enterokokken.setText(Integer.toString(enterokokkenValue)+" / 100 ml");
			}
			
			TextView date = (TextView) rootView.findViewById(R.id.textLetzteUberprufung);
			String datum = getArguments().getString(BADE_STELLEN_DATUM);
			date.setText(datum);
			
			return rootView;
		}
}
