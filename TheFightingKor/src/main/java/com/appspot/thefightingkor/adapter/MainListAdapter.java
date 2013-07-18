package com.appspot.thefightingkor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appspot.thefightingkor.R;

import java.util.List;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 7. 13..
 */
public class MainListAdapter extends ArrayAdapter<String> {

    public MainListAdapter(Context context, List<String> objects) {
        super(context, 0, objects);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_list_item, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }else {

            holder = (Holder)convertView.getTag();
        }

        holder.name.setText(getItem(position));

        return convertView;
    }

    class Holder  {
        @InjectView(R.id.arena_name) TextView name;

        public Holder(View v) {
            Views.inject(this, v);
        }
    }
}
