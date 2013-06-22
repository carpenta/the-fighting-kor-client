package com.appspot.thefightingkor.task;

import android.os.AsyncTask;
import android.util.Log;

import com.appspot.thefightingkor.data.Participant;
import com.appspot.thefightingkor.task.callback.ServerTaskCallback;
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
 * Created by mc2e on 13. 6. 22..
 */
public class ServerTask extends AsyncTask<String, Integer, ArrayList<Participant>> {

    private final String url = "http://the-fighting-kor.appspot.com/json";

    private ServerTaskCallback mCallback;

    private OkHttpClient client = null;

    public ServerTask(ServerTaskCallback mCallback) {
        this.mCallback = mCallback;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        client = new OkHttpClient();
    }

    @Override
    protected ArrayList<Participant> doInBackground(String... strings) {

        ArrayList<Participant> list = new ArrayList<Participant>();


        try {
            URL site = new URL(url);

            String json = get(site);

            Gson gson = new Gson();

            JsonParser parser = new JsonParser();

            JsonArray jsonArray = parser.parse(json).getAsJsonArray();

            for(JsonElement item : jsonArray) {

                Log.d("IntroActivity", "item: " +item.toString());

                    Participant participant = gson.fromJson(item.getAsJsonObject(), Participant.class);

                    list.add(participant);
            }

            Log.d("IntroActivity", "List Size: " +list.size());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<Participant> result) {
        super.onPostExecute(result);

        mCallback.onTaskCompleted(result);
    }

    private String get(URL url) throws IOException {
        String result = "";

        HttpURLConnection connection = client.open(url);

        InputStream in = null;

        try{
            in = connection.getInputStream();

            byte[] response = readFully(in);

            return new String(response, "UTF-8");
        } finally {
            if(in != null)
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
