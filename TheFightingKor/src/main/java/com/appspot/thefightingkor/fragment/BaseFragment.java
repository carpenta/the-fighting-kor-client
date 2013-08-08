package com.appspot.thefightingkor.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.appspot.thefightingkor.BaseApp;
import com.appspot.thefightingkor.activity.IntroAcitity;

/**
 * Created by mc2e on 13. 6. 21..
 */
public class BaseFragment extends Fragment {

    private IntroAcitity activity = null;

    private final String MAIN_TAG = "mainfragment";

    public final String ENTRY_TAG = "entryfragment";

    public final String GAME_LIST_TAG = "game_list_";

    public final String GAME_RESULT_LIST = "game_result_list";

    public final String GAME_RESULT_INFO = "game_result_info";

    private BaseApp mBaseApp = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(activity instanceof IntroAcitity) {
            this.activity = ((IntroAcitity)activity);
        }

        mBaseApp = (BaseApp)activity.getApplicationContext();
    }

    public void executeFragmet(String tag, int pos) {

        if(activity != null) {
            activity.executeFragment(tag, pos);
        }
    }

    public void executeFragmet(String tag, String id) {

        if(activity != null) {
            activity.executeFragment(tag, id);
        }
    }

    public void displayLoading(boolean show) {
        if(activity != null) {
            activity.displayLoading(show);
        }
    }

    public BaseApp getApp() {

        return this.mBaseApp;
    }
}
