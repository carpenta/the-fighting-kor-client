package com.appspot.thefightingkor.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.appspot.thefightingkor.R;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by Administrator on 13. 7. 19.
 */
public class InfoActivity extends BaseActivity {

    @InjectView(R.id.info_main_frame)
    FrameLayout parentView;

    @InjectView(R.id.frame_license)
    View licenseView;
    @InjectView(R.id.frame_info)
    View informationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Views.inject(this);

        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        int info = getIntent().getIntExtra(INTENT_INFO, ACTION_INFO);

        if(info == ACTION_INFO) {
            licenseView.setVisibility(View.GONE);
        }else {
            informationView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
