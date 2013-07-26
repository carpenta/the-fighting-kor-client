package com.appspot.thefightingkor.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.data.Player;
import com.appspot.thefightingkor.util.Utils;

import static butterknife.Views.findById;

/**
 * Created by Administrator on 13. 7. 15.
 */
public class PlayerView {

    TextView name, assoc, weight, group;
    ImageView grade;

    String[] gradeLevel = new String[5];

    public PlayerView(View v, Context ctx) {

        name = findById(v, R.id.game_player_name);
        grade = findById(v, R.id.game_player_image);
        assoc = findById(v, R.id.game_player_assoc);
        weight = findById(v, R.id.game_player_weight);
        group = findById(v, R.id.game_player_group);

        gradeLevel = ctx.getResources().getStringArray(R.array.grade_level);
    }

    public void setData(Player p) {

        if(p != null) {
            name.setText(p.getName());
            assoc.setText(p.getAssoc());
            weight.setText(p.getWeight());
            group.setText(p.getGroup());

            String playerGrade = p.getGrade();

            int res = Utils.getImageRes(gradeLevel, playerGrade);
            grade.setImageResource(res);
        }
    }
}
