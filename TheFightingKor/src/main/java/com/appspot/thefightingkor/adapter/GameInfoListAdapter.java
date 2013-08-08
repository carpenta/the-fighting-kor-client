package com.appspot.thefightingkor.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.data.Game;
import com.appspot.thefightingkor.data.Player;
import com.appspot.thefightingkor.util.ColorUtil;
import com.appspot.thefightingkor.view.PlayerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 7. 14..
 */
public class GameInfoListAdapter extends ArrayAdapter<Game> {

    public GameInfoListAdapter(Context context, ArrayList<Game> objects) {
        super(context, 0, objects);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public Game getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = null;

        if(convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.game, parent, false);
            holder = new Holder(convertView);
            initView(holder);
            convertView.setTag(holder);
        }else {

            holder = (Holder)convertView.getTag();
        }

        Game game = getItem(position);
        if(game != null) {
            setValue(holder, getItem(position));
        }


        return convertView;
    }

    private void initView(Holder h) {

        h.player1 = new PlayerView(h.player1View, getContext());
        h.player2 = new PlayerView(h.player2View, getContext());
    }

    private void setValue(Holder h, Game item) {

        h.gameName.setText(item.getInfo().getName());
        h.gameResult.setText(getStatus(item));
        h.tournamentNumber.setText(item.getTournamentNum());
        h.player1.setData(item.getPlayer1());
        h.player2.setData(item.getPlayer2());
        h.winner.setText(setWinner(item));
    }

    class Holder {

        @InjectView(R.id.game_name) TextView gameName;
        @InjectView(R.id.game_result) TextView gameResult;
        @InjectView(R.id.game_number) TextView tournamentNumber;
        @InjectView(R.id.game_player1) View player1View;
        @InjectView(R.id.game_player2) View player2View;
        @InjectView(R.id.game_winner) TextView winner;

        PlayerView player1;
        PlayerView player2;

        public Holder(View v) {
            Views.inject(this, v);
        }
    }

    private String getStatus(Game g) {

        String result = "";

        String status = g.getStatus();

        if(status != null) {
            if(status.equalsIgnoreCase("running")) {
                result = getContext().getString(R.string.text_game_play);
            }else {
                result = getContext().getString(R.string.text_game_end);
            }
        }

        return result;
    }

    private String setWinner(Game g) {

        String result = "";

        String winnerId = g.getWinner().getId();

        String player1Id = g.getPlayer1().getId();

        String player2Id = g.getPlayer2().getId();

        if(winnerId == null || winnerId.equalsIgnoreCase("")) {
            return "";
        }else {

            if (winnerId.equalsIgnoreCase(player1Id)) {
                result = "WINNER\n"+g.getPlayer1().getName();
            }else if(winnerId.equalsIgnoreCase(player2Id)) {
                result = "WINNER\n"+g.getPlayer2().getName();
            }
        }

        return result;
    }

}
