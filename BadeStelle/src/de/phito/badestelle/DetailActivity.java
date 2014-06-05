package de.phito.badestelle;

import java.util.Locale;

import de.phito.badestelle.detailview.DataFragment;
import de.phito.badestelle.detailview.DescriptionFragment;
import de.phito.badestelle.detailview.MapFragment;
import de.phito.badestelle.model.BadeStelle;
import de.phito.badestelle.model.BadeStellenContainer;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailActivity extends FragmentActivity implements
		ActionBar.TabListener {

	protected static final String SHOW_DETAIL_ID = "SHOW_DETAIL_ID";

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	private BadeStelle badeStelle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Integer badeStellenId = getIntent().getIntExtra(DetailActivity.SHOW_DETAIL_ID, 0);
		
		BadeStellenContainer badeStellen = BadeStellenContainer.getInstance();
		badeStellen.loadBadeStellenJSON(getApplicationContext());
		this.badeStelle = badeStellen.getBadeStelleById(badeStellenId);
		
		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Bundle args = new Bundle();
			args.putString(DescriptionFragment.BADE_STELLEN_NAME, badeStelle.name);
			args.putString(DescriptionFragment.BADE_STELLEN_BEZIRK, badeStelle.district);
			args.putString(DataFragment.BADE_STELLEN_DATUM, badeStelle.lastUpdate.toLocaleString());
			args.putInt(DataFragment.BADE_STELLEN_ECOLI, badeStelle.ecoliPerDeciLiter);
			args.putInt(DataFragment.BADE_STELLEN_ENTEROKOKKEN, badeStelle.enterokokkenPerDeciLiter);
			args.putInt(DataFragment.BADE_STELLEN_SICHTWEITE, badeStelle.viewDepthCM);
			args.putDouble(MapFragment.BADE_STELLEN_COORDINATES_LAT, badeStelle.coordinates.latitude);
			args.putDouble(MapFragment.BADE_STELLEN_COORDINATES_LON, badeStelle.coordinates.longitude);
			
			if(position == 0){
				Fragment fragment = new DescriptionFragment();
				fragment.setArguments(args);
				return fragment;
			} else if(position == 1){
				// data
				Fragment fragment = new DataFragment();
				fragment.setArguments(args);
				return fragment; 
			} else {
				// pos == 2
				// map
				Fragment fragment = new MapFragment();
				fragment.setArguments(args);
				return fragment;
			}
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section_description).toUpperCase(l);
			case 1:
				return getString(R.string.title_section_values).toUpperCase(l);
			case 2:
				return getString(R.string.title_section_map).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
