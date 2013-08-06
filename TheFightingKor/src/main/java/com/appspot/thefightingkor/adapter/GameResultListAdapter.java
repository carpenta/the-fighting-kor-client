package com.appspot.thefightingkor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.data.GameResultListInfo;

import java.util.List;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 8. 6..
 */
public class GameResultListAdapter extends ArrayAdapter<GameResultListInfo>{

    public GameResultListAdapter(Context context, List<GameResultListInfo> objects) {
        super(context, 0, objects);
    }

    @Override
    public GameResultListInfo getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = null;

        if(convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_list_item, parent, false);

            holder = new Holder(convertView);

            convertView.setTag(holder);
        }else {

            holder = (Holder)convertView.getTag();
        }

        String name = getItem(position).getTournamentName();

        if(name !=null)
            holder.tournamentName.setText(name);

        return convertView;
    }

    class Holder {

        @InjectView(R.id.arena_name)
        TextView tournamentName;

        Holder(View v) {
            Views.inject(this, v);
        }
    }
}
