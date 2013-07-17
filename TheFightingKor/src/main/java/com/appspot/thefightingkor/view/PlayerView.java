package com.appspot.thefightingkor.view;

import android.view.View;
import android.widget.TextView;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.data.Player;

/**
 * Created by Administrator on 13. 7. 15.
 */
public class PlayerView {

    private TextView id, name, grade, assoc, weight, etc;

    public PlayerView(View v) {

        id = (TextView)v.findViewById(R.id.game_player_id);
        name = (TextView)v.findViewById(R.id.game_player_name);
        grade = (TextView)v.findViewById(R.id.game_player_grade);
        assoc = (TextView)v.findViewById(R.id.game_player_assoc);
        weight = (TextView)v.findViewById(R.id.game_player_weight);
        etc = (TextView)v.findViewById(R.id.game_player_etc);
    }

    public void setData(Player p) {
        //id.setText(p.getId());
        name.setText(p.getName());
        grade.setText(p.getGrade());
        assoc.setText(p.getAssoc());
        weight.setText(p.getWeight());
        etc.setText(p.getEtc());
    }
}
