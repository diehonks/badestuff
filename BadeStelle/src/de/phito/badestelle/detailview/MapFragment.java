package de.phito.badestelle.detailview;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.SimpleLocationOverlay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.phito.badestelle.R;

/**
 * The Class MapFragment creates a fragment that is populated with a map of the position of the lake
 */
public class MapFragment extends Fragment {
		
		/** The Constant BADE_STELLEN_COORDINATES_LAT. */
		public static final String BADE_STELLEN_COORDINATES_LAT = "BADE_STELLEN_COORDINATES_LAT";
		
		/** The Constant BADE_STELLEN_COORDINATES_LON. */
		public static final String BADE_STELLEN_COORDINATES_LON = "BADE_STELLEN_COORDINATES_LON";
		
		/**
		 * Instantiates a new map fragment.
		 */
		public MapFragment() {
			
		}

		/* (non-Javadoc)
		 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
		 */
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_detail_map, container, false);
			MapView mapView = (MapView) rootView.findViewById(R.id.mapview);
			double lat = getArguments().getDouble(BADE_STELLEN_COORDINATES_LAT);
			double lon = getArguments().getDouble(BADE_STELLEN_COORDINATES_LON);
			
			// add a marker at the position of the lake
			GeoPoint lakePosition = new GeoPoint(lat ,lon);        
	        SimpleLocationOverlay locationOverlay = new SimpleLocationOverlay(container.getContext());
	        locationOverlay.setLocation(lakePosition);
	        mapView.getOverlays().add(locationOverlay);
			
	        // set image source to MAPNIK provider and enable touch controls
			mapView.setTileSource(TileSourceFactory.MAPNIK); 
			mapView.setBuiltInZoomControls(true); 
			mapView.setMultiTouchControls(true); 
			IMapController mapController = mapView.getController();
			
			// set position and zoom to something big, so the whole lake can be seen
			mapController.setZoom(13);
			mapController.setCenter(new GeoPoint(lat, lon));
			
			return rootView;
		}
}
