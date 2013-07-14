package com.appspot.thefightingkor.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.appspot.thefightingkor.data.Game;

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



        return super.getView(position, convertView, parent);
    }
}
