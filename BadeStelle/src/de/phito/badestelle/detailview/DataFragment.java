package de.phito.badestelle.detailview;

import java.util.logging.Logger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import de.phito.badestelle.R;

public class DataFragment extends Fragment {
		public static final String BADE_STELLEN_SICHTWEITE = "BADE_STELLEN_SICHTWEITE";
		public static final String BADE_STELLEN_ECOLI = "BADE_STELLEN_ECOLI";
		public static final String BADE_STELLEN_ENTEROKOKKEN= "BADE_STELLEN_ENTEROKOKKEN";
		public static final String BADE_STELLEN_DATUM = "BADE_STELLEN_DATUM";

		public DataFragment() {
			
		}

		private Logger logger = Logger.getLogger(DataFragment.class.getSimpleName());

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
