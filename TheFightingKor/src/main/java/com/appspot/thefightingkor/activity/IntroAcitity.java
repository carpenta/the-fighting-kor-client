package com.appspot.thefightingkor.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.fragment.EntryListFragment;
import com.appspot.thefightingkor.task.ServerTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class IntroAcitity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        executeFragment();
    }

    private void executeFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new EntryListFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.intro_acitity, menu);
        return true;
    }
    
}
