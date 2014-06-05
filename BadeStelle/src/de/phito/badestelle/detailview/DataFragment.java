package de.phito.badestelle.detailview;

import java.util.logging.Logger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import de.phito.badestelle.R;

// TODO: Auto-generated Javadoc
/**
 * The Class DataFragment.
 */
public class DataFragment extends Fragment {
		
		/** The Constant BADE_STELLEN_SICHTWEITE. */
		public static final String BADE_STELLEN_SICHTWEITE = "BADE_STELLEN_SICHTWEITE";
		
		/** The Constant BADE_STELLEN_ECOLI. */
		public static final String BADE_STELLEN_ECOLI = "BADE_STELLEN_ECOLI";
		
		/** The Constant BADE_STELLEN_ENTEROKOKKEN. */
		public static final String BADE_STELLEN_ENTEROKOKKEN= "BADE_STELLEN_ENTEROKOKKEN";
		
		/** The Constant BADE_STELLEN_DATUM. */
		public static final String BADE_STELLEN_DATUM = "BADE_STELLEN_DATUM";

		/**
		 * Instantiates a new data fragment.
		 */
		public DataFragment() {
			
		}

		/** The logger. */
		private Logger logger = Logger.getLogger(DataFragment.class.getSimpleName());

		/* (non-Javadoc)
		 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
		 */
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_detail_data, container, false);
			
			TextView sichtweite = (TextView) rootView.findViewById(R.id.textSichtweite);
			int sichtweiteValue = getArguments().getInt(BADE_STELLEN_SICHTWEITE);
			sichtweite.setText(Integer.toString(sichtweiteValue));
			
			TextView ecoli = (TextView) rootView.findViewById(R.id.textEcoli);
			int ecolivalue = getArguments().getInt(BADE_STELLEN_ECOLI);
			ecoli.setText(Integer.toString(ecolivalue));
			
			TextView enterokokken = (TextView) rootView.findViewById(R.id.textEnterokokken);
			int enterokokkenValue = getArguments().getInt(BADE_STELLEN_ENTEROKOKKEN);
			enterokokken.setText(Integer.toString(enterokokkenValue));
			
			TextView date = (TextView) rootView.findViewById(R.id.textLetzteUberprufung);
			String datum = getArguments().getString(BADE_STELLEN_DATUM);
			date.setText(datum);
			
			return rootView;
		}
}
