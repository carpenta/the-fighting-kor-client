package com.appspot.thefightingkor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.data.GameResultInfo;
import com.appspot.thefightingkor.data.GameResultListInfo;
import com.appspot.thefightingkor.data.Player;
import com.appspot.thefightingkor.util.Utils;

import java.util.List;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 8. 6..
 */
public class GameResultInfoAdapter extends ArrayAdapter<Player>{

    private String[] gradeLevel = new String[5];

    public GameResultInfoAdapter(Context context, List<Player> objects) {
        super(context, 0, objects);

        gradeLevel = context.getResources().getStringArray(R.array.grade_level);
    }

    @Override
    public Player getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = null;

        if(convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.player, parent, false);

            holder = new Holder(convertView);

            convertView.setTag(holder);
        }else {

            holder = (Holder)convertView.getTag();
        }

        setData(holder, getItem(position));

        if(position == 0) {

            holder.result.setVisibility(View.VISIBLE);
            holder.result.setImageResource(R.drawable.medal_gold);
        }else if(position == 1) {
            holder.result.setVisibility(View.VISIBLE);
            holder.result.setImageResource(R.drawable.medal_silver);
        }else if(position == 2 || position == 3) {
            holder.result.setVisibility(View.VISIBLE);
            holder.result.setImageResource(R.drawable.medal_bronze);
        }else {
            holder.result.setVisibility(View.GONE);
        }


        return convertView;
    }

    private void setData(Holder h, Player item) {

        h.name.setText(item.getName());
        h.association.setText(item.getAssoc());
        h.weight.setText(item.getWeight());
        h.group.setText(item.getGroup());

        int res = Utils.getImageRes(gradeLevel, item.getGrade());
        h.image.setImageResource(res);
    }

    class Holder {

        @InjectView(R.id.player_name)       TextView name;
        @InjectView(R.id.player_assoc)      TextView association;
        @InjectView(R.id.player_weight)     TextView weight;
        @InjectView(R.id.player_group)      TextView group;
        @InjectView(R.id.player_image)      ImageView image;
        @InjectView(R.id.medal_result)      ImageView result;

        public Holder(View v) {
            Views.inject(this, v);
        }
    }
}
