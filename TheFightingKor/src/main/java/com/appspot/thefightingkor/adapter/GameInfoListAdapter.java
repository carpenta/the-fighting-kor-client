package com.appspot.thefightingkor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.data.Game;
import com.appspot.thefightingkor.data.Player;
import com.appspot.thefightingkor.view.PlayerView;

import java.util.ArrayList;
import java.util.List;

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
            holder = new Holder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.game, parent, false);
            initView(holder, convertView);
            convertView.setTag(holder);
        }else {
            holder = (Holder)convertView.getTag();
        }

        setValue(holder, getItem(position));

        return convertView;
    }

    private void initView(Holder h, View v) {

        h.gameResult = (TextView)v.findViewById(R.id.game_result);
        h.tournamentNumber = (TextView)v.findViewById(R.id.game_number);
        h.player1View = v.findViewById(R.id.game_player1);
        h.player2View = v.findViewById(R.id.game_player2);

        h.player1 = new PlayerView(h.player1View);
        h.player2 = new PlayerView(h.player2View);
    }

    private void setValue(Holder h, Game item) {

        h.gameResult.setText(item.getStatus());
        h.tournamentNumber.setText(item.getTournamentNum());

        h.player1.setData(item.getPlayer1());
        h.player2.setData(item.getPlayer2());
    }

    class Holder {
        TextView gameResult;
        TextView tournamentNumber;

        View player1View;
        View player2View;

        PlayerView player1;
        PlayerView player2;
    }
}
