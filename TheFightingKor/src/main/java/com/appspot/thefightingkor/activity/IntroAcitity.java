package com.appspot.thefightingkor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.fragment.BaseFragment;
import com.appspot.thefightingkor.fragment.GameInfoListFragment;
import com.appspot.thefightingkor.fragment.GameResultInfoFragment;
import com.appspot.thefightingkor.fragment.GameResultListFragment;
import com.appspot.thefightingkor.fragment.PlayerListFragment;
import com.appspot.thefightingkor.fragment.MainFragment;

import butterknife.InjectView;
import butterknife.Views;

public class IntroAcitity extends BaseActivity {

    private String[] mTitles = null;

    @InjectView(R.id.main_progressbar) ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Views.inject(this);

        mTitles = getResources().getStringArray(R.array.main_menu_array);

        executeFragment(MAIN_TAG, 0);
    }

    private final String MAIN_TAG = "mainfragment";

    private final String ENTRY_TAG = "entryfragment";

    private final String GAME_LIST_TAG = "game_list_";

    private final String GAME_RESULT_LIST = "game_result_list";

    private final String GAME_RESULT_INFO = "game_result_info";

    public void executeFragment(String tag, int pos) {

//        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);

        BaseFragment fragment = null;

        if(tag.equalsIgnoreCase(MAIN_TAG)) {

            fragment= new MainFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment, tag)
                    .commitAllowingStateLoss();
        }else if(tag.equalsIgnoreCase(ENTRY_TAG)) {

            fragment = new PlayerListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment, tag)
                    .addToBackStack(null)
                    .commitAllowingStateLoss();
        }else if(tag.equalsIgnoreCase(GAME_LIST_TAG)) {

            fragment = new GameInfoListFragment(pos, mTitles[pos-1]);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment, tag+pos)
                    .addToBackStack(null)
                    .commitAllowingStateLoss();
        } else if(tag.equalsIgnoreCase(GAME_RESULT_LIST)) {

            fragment = new GameResultListFragment(mTitles[4]);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment, tag)
                    .addToBackStack(null)
                    .commitAllowingStateLoss();
        }
    }

    public void executeFragment(String tag, String id) {

//        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);

        BaseFragment fragment = null;

        if(tag.equalsIgnoreCase(GAME_RESULT_INFO)) {

            fragment= new GameResultInfoFragment(id);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment, tag)
                    .addToBackStack(null)
                    .commitAllowingStateLoss();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.intro_acitity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home) {

            boolean isMain = getSupportFragmentManager().findFragmentByTag(MAIN_TAG).isVisible();

            if(isMain) {
                getActionBar().setDisplayHomeAsUpEnabled(false);
            }else {
                onBackPressed();
            }
        }else if(item.getItemId() == R.id.action_license) {
            Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
            intent.putExtra(INTENT_INFO, ACTION_LICENSE);
            startActivity(intent);
        }else if(item.getItemId() == R.id.action_information){
            Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
            intent.putExtra(INTENT_INFO, ACTION_INFO);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayLoading(boolean show) {

        Log.w("IntroActivity", "displayLoading is executed!");

        if(mProgress == null) {
            Log.w("IntroActivity", "ProgressBar is Null");
            return;
        }

        if(show) {
            if(mProgress.getVisibility() == View.GONE) {
                Log.w("IntroActivity", "displayLoading is VISIBLE!");
                mProgress.setVisibility(View.VISIBLE);
            }
        }else {

            if(mProgress.getVisibility() == View.VISIBLE) {
                Log.w("IntroActivity", "displayLoading is GONE!");
                mProgress.setVisibility(View.GONE);
            }
        }
    }
}
