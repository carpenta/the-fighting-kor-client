package com.appspot.thefightingkor.data;

import com.google.gson.annotations.SerializedName;

import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by mc2e on 13. 7. 14..
 */
public class Game {

    @SerializedName("tournament") private Tournament info;
    @SerializedName("id") private String id;
    @SerializedName("player1") private Player player1;
    @SerializedName("player2") private Player player2;
    @SerializedName("status") private String status;
    @SerializedName("winner") private Player winner;
    @SerializedName("tournament_num") private String tournamentNum;
    @SerializedName("playground_num") private String playgroundNum;
    @SerializedName("fight_level") private String torunamentLevel;

    public String getPlaygroundNum() {
        return playgroundNum;
    }

    public Tournament getInfo() {
        return info;
    }

    public String getId() {
        return id;
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

    public void setStatus(String result) {
        this.status = result;
    }


    public Player getWinner() {
        return winner;
    }

    public String getTournamentNum() {
        return tournamentNum;
    }

    private boolean isStillPlaying = false;

    public boolean isStillPlaying() {

        if(getStatus() != null) {

            if(status.equalsIgnoreCase("running")) {
                isStillPlaying = true;
            }else {
                isStillPlaying = false;
            }
        }

        return isStillPlaying;
    }
}
