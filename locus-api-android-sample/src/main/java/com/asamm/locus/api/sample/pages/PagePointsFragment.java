package com.asamm.locus.api.sample.pages;

import com.asamm.locus.api.sample.utils.BasicAdapterItem;
import com.asamm.locus.api.sample.utils.SampleCalls;

import java.util.ArrayList;
import java.util.List;

import locus.api.android.utils.LocusUtils;

/**
 * Created by menion on 29/08/2016.
 * This code is part of Locus project from Asamm Software, s. r. o.
 */
public class PagePointsFragment extends ABasePageFragment {

	/**
	 * Empty constructor.
	 */
	public PagePointsFragment() {}

	@Override
	protected List<BasicAdapterItem> getItems() {
		List<BasicAdapterItem> items = new ArrayList<>();
		items.add(new BasicAdapterItem(1,
				"Import one point",
				"Send one simple point to Locus and execute 'import' request. If Locus does not run, this intent starts it."));
		items.add(new BasicAdapterItem(2,
				"Import more points at once",
				"One of possibilities, how to send data to Locus and execute 'import'. Number of points is limited by capacity of Intent. On 2.X devices - 1 MB, one 4.X+ devices - 2 MB."));
		items.add(new BasicAdapterItem(3,
				"Display one point with icon",
				"Send one simple point to Locus together with icon defined as bitmap."));
		items.add(new BasicAdapterItem(4,
				"Display more points with icon",
				"Send more waypoints, with different attached icons (all as bitmaps)."));
		items.add(new BasicAdapterItem(5,
				"Display Geocaching point",
				"Geocache points behave a little bit different in Locus. This sample show how to create it and how to display it on a map."));
		items.add(new BasicAdapterItem(6,
				"Display more Geocaches over intent",
				"Improved version, where we send more geocache points at once."));
		items.add(new BasicAdapterItem(7,
				"Display more Geocaches over local File",
				"Second way how to send data (not just geocaches) to Locus is over file. Here is only limit memory on device for every app because Locus loads all data at once. Method is slower then \"intent\" only method, but limits on number of points are not so strict."));
		items.add(new BasicAdapterItem(8,
				"Display point with OnDisplay callback",
				"Perfect example, how to handle own points in Locus. This method allows to be notified, that user tapped on your point. You may then supply additional information and send them back to Locus, before 'Point screen' appear."));
		items.add(new BasicAdapterItem(9,
				"Request ID of waypoint by it's name",
				"Allows to search in Locus internal point database for point by it's name. Result is list of waypoints (it's IDs), that match requested name."));
		items.add(new BasicAdapterItem(10,
				"Display 'Point screen' of certain point",
				"Allows to display main 'Point screen' of certain point defined by it's ID."));
		return items;
	}

	@Override
	protected void onItemClicked(int itemId, LocusUtils.LocusVersion activeLocus) throws Exception {
		switch (itemId) {
			case 1:
				SampleCalls.callSendOnePoint(getActivity());
				break;
			case 2:
				SampleCalls.callSendMorePoints(getActivity());
				break;
			case 3:
				SampleCalls.callSendOnePointWithIcon(getActivity());
				break;
			case 4:
				SampleCalls.callSendMorePointsWithIcons(getActivity());
				break;
			case 5:
				SampleCalls.callSendOnePointGeocache(getActivity());
				break;
			case 6:
				SampleCalls.callSendMorePointsGeocacheIntentMehod(getActivity());
				break;
			case 7:
				SampleCalls.callSendMorePointsGeocacheFileMehod(getActivity());
				break;
			case 8:
				SampleCalls.callSendOnePointWithCallbackOnDisplay(getActivity());
				break;
			case 9:
				SampleCalls.callRequestPointIdByName(getActivity(), activeLocus);
				break;
			case 10:
				SampleCalls.callRequestDisplayPointScreen(getActivity(), activeLocus, 3);
				break;
		}
	}
}
