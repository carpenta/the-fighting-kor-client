package com.appspot.thefightingkor.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 13. 8. 7.
 */
public class GameResultInfo {

    @SerializedName("tournament_name") private String tournamentName;
    @SerializedName("tournament_num") private String torunamentNumber;
    @SerializedName("id") private String id;
    @SerializedName("tournament_level") private String level;

    @SerializedName("winner1") private Player gold;
    @SerializedName("winner2") private Player silver;
    @SerializedName("winner3") private Player bronze1;
    @SerializedName("winner4") private Player bronze2;

    public String getTournamentName() {
        return tournamentName;
    }

    public String getTorunamentNumber() {
        return torunamentNumber;
    }

    public String getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public Player getGold() {
        return gold;
    }

    public Player getSilver() {
        return silver;
    }

    public Player getBronze1() {
        return bronze1;
    }

    public Player getBronze2() {
        return bronze2;
    }
}
