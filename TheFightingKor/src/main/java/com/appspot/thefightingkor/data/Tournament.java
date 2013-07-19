package com.appspot.thefightingkor.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mc2e on 13. 7. 20..
 */
public class Tournament {

    @SerializedName("tournament_name") private String name;
    @SerializedName("tournament_num") private String number;
    @SerializedName("tournament_level") private String level;
    @SerializedName("id") private String id;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getLevel() {
        return level;
    }

    public String getId() {
        return id;
    }
}
