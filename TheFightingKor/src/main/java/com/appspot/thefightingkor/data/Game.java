package com.appspot.thefightingkor.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mc2e on 13. 7. 14..
 */
public class Game {

    @SerializedName("gid") private String gid;
    @SerializedName("player1") private Player player1;
    @SerializedName("player2") private Player player2;
    @SerializedName("status") private String status;
    @SerializedName("winner") private String winner;

    public String getGid() {
        return gid;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String getStatus() {
        return status;
    }

    public String getWinner() {
        return winner;
    }
}
