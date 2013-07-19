package com.appspot.thefightingkor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.data.Player;

import java.util.List;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 6. 22..
 */
public class PlayerListAdapter extends ArrayAdapter<Player> {

    public PlayerListAdapter(Context context, List<Player> obj) {
        super(context, 0, obj);
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

        return convertView;
    }

    private void setData(Holder h, Player item) {

        h.id.setText(item.getId());
        h.name.setText(item.getName());
        h.association.setText(item.getAssoc());
        h.weight.setText(item.getWeight());
        h.grade.setText(item.getGrade());
        h.group.setText(item.getGroup());
    }

    class Holder {

        @InjectView(R.id.player_id)         TextView id;
        @InjectView(R.id.player_name)       TextView name;
        @InjectView(R.id.player_assoc)      TextView association;
        @InjectView(R.id.player_weight)     TextView weight;
        @InjectView(R.id.player_grade)      TextView grade;
        @InjectView(R.id.player_group)   TextView group;

        public Holder(View v) {
            Views.inject(this, v);
        }
    }
}
