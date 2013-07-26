package com.appspot.thefightingkor;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.appspot.thefightingkor.util.OkHttpStack;
import com.google.gson.Gson;

/**
 * Created by mc2e on 13. 7. 26..
 */
public class BaseApp extends Application {

    private RequestQueue mQueue;

    private Gson mGson;
    @Override
    public void onCreate() {
        super.onCreate();

        mQueue = Volley.newRequestQueue(this, new OkHttpStack());
        mGson = new Gson();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public RequestQueue getRequestQueue() {
        return this.mQueue;
    }

    public Gson getGSon() {
        return this.mGson;
    }
}
