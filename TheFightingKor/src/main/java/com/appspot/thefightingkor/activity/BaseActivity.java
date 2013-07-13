package com.appspot.thefightingkor.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by mc2e on 13. 6. 21..
 */
public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().setHomeButtonEnabled(true);
    }
}
