package com.appspot.thefightingkor.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.appspot.thefightingkor.activity.IntroAcitity;

/**
 * Created by mc2e on 13. 6. 21..
 */
public class BaseFragment extends Fragment {

    private IntroAcitity activity = null;

    private final String MAIN_TAG = "mainfragment";

    public final String ENTRY_TAG = "entryfragment";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(activity instanceof IntroAcitity) {
            this.activity = ((IntroAcitity)activity);
        }
    }

    public void executeFragmet(String tag) {

        if(activity != null) {
            activity.executeFragment(tag);
        }
    }
}
