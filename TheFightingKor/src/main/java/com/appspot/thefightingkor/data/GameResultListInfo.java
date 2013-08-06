package com.appspot.thefightingkor.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mc2e on 13. 8. 6..
 */
public class GameResultListInfo {

    @SerializedName("tournament_name") private String tournamentName;
    @SerializedName("tournament_level") private String tournamentLevel;
    @SerializedName("id") private String id;

    public String getTournamentName() {
        return tournamentName;
    }

    public String getTournamentLevel() {
        return tournamentLevel;
    }

    public String getId() {
        return id;
    }
}
