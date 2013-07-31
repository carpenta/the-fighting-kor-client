package com.appspot.thefightingkor.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.appspot.thefightingkor.R;

/**
 * Created by mc2e on 13. 6. 21..
 */
public class BaseActivity extends FragmentActivity {

    protected final String INTENT_INFO = "action_info";

    protected final int ACTION_INFO = 0;
    protected final int ACTION_LICENSE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setLogo(R.drawable.logo);
    }
}
