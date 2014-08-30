package com.jillberthestillore.flames.factories;

import java.util.HashMap;

import android.support.v4.app.Fragment;

public class FragmentFactory {

	private static HashMap<String, Class<? extends Fragment>> map = new HashMap<String, Class<? extends Fragment>>();
	
	private FragmentFactory() {
		
	}
	
	public static void register(String fragmentId, Class<? extends Fragment> fragmentClass) {
		map.put(fragmentId, fragmentClass);
	}
	
	public static Fragment create(String fragmentId) {
		try {
			return map.get(fragmentId).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
