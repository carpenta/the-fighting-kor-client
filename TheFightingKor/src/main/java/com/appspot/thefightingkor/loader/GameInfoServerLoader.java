package com.appspot.thefightingkor.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.appspot.thefightingkor.data.Game;
import com.squareup.okhttp.OkHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by mc2e on 13. 7. 14..
 */
public class GameInfoServerLoader extends AsyncTaskLoader<ArrayList<Game>>{

    private OkHttpClient client = null;

    public GameInfoServerLoader(Context context) {
        super(context);
        client = new OkHttpClient();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        onForceLoad();
    }

    @Override
    public ArrayList<Game> loadInBackground() {

        ArrayList<Game> result = new ArrayList<Game>();



        return result;
    }

    private String get(URL url) throws IOException {

        HttpURLConnection connection = client.open(url);

        InputStream in = null;

        try {
            in = connection.getInputStream();

            byte[] response = readFully(in);

            return new String(response, "UTF-8");
        } finally {
            if (in != null)
                in.close();
        }
    }

    byte[] readFully(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        for (int count; (count = in.read(buffer)) != -1; ) {
            out.write(buffer, 0, count);
        }
        return out.toByteArray();
    }
}
