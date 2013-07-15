package com.appspot.thefightingkor.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.fragment.BaseFragment;
import com.appspot.thefightingkor.fragment.GameInfoListFragment;
import com.appspot.thefightingkor.fragment.PlayerListFragment;
import com.appspot.thefightingkor.fragment.MainFragment;

public class IntroAcitity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        executeFragment(MAIN_TAG);
    }

    private final String MAIN_TAG = "mainfragment";

    private final String ENTRY_TAG = "entryfragment";

    private final String GAME_TAG = "gameinfofragment";

    public void executeFragment(String tag) {

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
        }else if(tag.equalsIgnoreCase(GAME_TAG)) {
            fragment = new GameInfoListFragment();
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
        }

        return super.onOptionsItemSelected(item);
    }
}
