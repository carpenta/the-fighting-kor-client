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
            holder = new Holder();
            initLayout(holder, convertView);
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
        h.etc.setText(item.getEtc());
    }

    private void initLayout(Holder h, View v) {

        h.id = (TextView)v.findViewById(R.id.player_id);
        h.name = (TextView)v.findViewById(R.id.player_name);
        h.association = (TextView)v.findViewById(R.id.player_assoc);
        h.weight = (TextView)v.findViewById(R.id.player_weight);
        h.grade = (TextView)v.findViewById(R.id.player_grade);
        h.etc = (TextView)v.findViewById(R.id.player_etc_info);
    }


    class Holder {

        TextView id;
        TextView name;
        TextView association;
        TextView weight;
        TextView grade;
        TextView etc;
    }
}
