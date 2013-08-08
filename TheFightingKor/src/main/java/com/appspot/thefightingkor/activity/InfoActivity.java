package com.appspot.thefightingkor.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.appspot.thefightingkor.R;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by Administrator on 13. 7. 19.
 */
public class InfoActivity extends BaseActivity {

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
