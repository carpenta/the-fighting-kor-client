package com.appspot.thefightingkor.util;

import android.util.Log;

import com.appspot.thefightingkor.data.Game;
import com.appspot.thefightingkor.data.Player;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * Created by mc2e on 13. 7. 26..
 */
public class ResponseParser {

    private String json;

    public ResponseParser(String json) {
        this.json = json;
    }

    public ArrayList<Game> getGameList(Gson gson) {

        ArrayList<Game> result = new ArrayList<Game>();

        JsonParser parser = new JsonParser();

        JsonArray jsonArray = parser.parse(json).getAsJsonArray();

        for (JsonElement item : jsonArray) {

            Log.d("IntroActivity", "item: " + item.toString());

            Game game = gson.fromJson(item.getAsJsonObject(), Game.class);
            result.add(game);
        }

        Log.d("IntroActivity", "List Size: " + result.size());


        return result;
    }

    public ArrayList<Player> getPlayerList(Gson gson) {

        ArrayList<Player> result = new ArrayList<Player>();

        JsonParser parser = new JsonParser();

        JsonArray jsonArray = parser.parse(json).getAsJsonArray();

        for (JsonElement item : jsonArray) {

            Log.d("IntroActivity", "item: " + item.toString());

            Player player = gson.fromJson(item.getAsJsonObject(), Player.class);
            result.add(player);
        }

        Log.d("IntroActivity", "List Size: " + result.size());


        return result;
    }
}
