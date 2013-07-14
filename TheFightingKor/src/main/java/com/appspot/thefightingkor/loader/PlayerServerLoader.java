package com.appspot.thefightingkor.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.appspot.thefightingkor.Server.ServerInfo;
import com.appspot.thefightingkor.data.Player;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by mc2e on 13. 7. 12..
 */
public class PlayerServerLoader extends AsyncTaskLoader<ArrayList<Player>> {

    private OkHttpClient client = null;

    public PlayerServerLoader(Context context) {
        super(context);

        client = new OkHttpClient();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        onForceLoad();
    }

    @Override
    public ArrayList<Player> loadInBackground() {
        ArrayList<Player> list = new ArrayList<Player>();


        try {
            URL site = new URL(ServerInfo.PLAYER_URL);

            String json = get(site);

            Gson gson = new Gson();

            JsonParser parser = new JsonParser();

            JsonArray jsonArray = parser.parse(json).getAsJsonArray();

            for (JsonElement item : jsonArray) {

                Log.d("IntroActivity", "item: " + item.toString());

                Player player = gson.fromJson(item.getAsJsonObject(), Player.class);

                list.add(player);
            }

            Log.d("IntroActivity", "List Size: " + list.size());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return list;
    }

    private String get(URL url) throws IOException {
        String result = "";

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
