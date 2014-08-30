package com.jillberthestillore.flames.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import butterknife.ButterKnife;

import com.jillberthestillore.flames.BusProvider;
import com.squareup.otto.Bus;

public class BaseFragment extends Fragment {
	
	Bus bus = BusProvider.getInstance();
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}

	@Override
	public void onPause() {
		super.onPause();
		bus.unregister(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		bus.register(this);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.inject(this, view);
	}
	
}
