package de.phito.badestelle.detailview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import de.phito.badestelle.R;

// TODO: Auto-generated Javadoc
/**
 * The Class DescriptionFragment.
 */
public class DescriptionFragment extends Fragment {
		
		/** The Constant BADE_STELLEN_NAME. */
		public static final String BADE_STELLEN_NAME = "BADE_STELLEN_NAME";
		
		/** The Constant BADE_STELLEN_BEZIRK. */
		public static final String BADE_STELLEN_BEZIRK = "BADE_STELLEN_BEZIRK";

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
			TextView locationName = (TextView) rootView.findViewById(R.id.textLocationName);
			locationName.setText(getArguments().getString(BADE_STELLEN_NAME));
			
			TextView districtName = (TextView) rootView.findViewById(R.id.textBezirk);
			districtName.setText(getArguments().getString(BADE_STELLEN_BEZIRK));
			return rootView;
		}
}
