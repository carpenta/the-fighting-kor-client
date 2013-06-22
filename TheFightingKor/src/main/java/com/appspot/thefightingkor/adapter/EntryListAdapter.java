package com.appspot.thefightingkor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.data.Participant;

import java.util.List;

/**
 * Created by mc2e on 13. 6. 22..
 */
public class EntryListAdapter extends ArrayAdapter<Participant> {

    private LayoutInflater mInflater;

    public EntryListAdapter(Context context, List<Participant> obj) {
        super(context, 0, obj);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public Participant getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = null;

        if(convertView == null) {

            convertView = mInflater.inflate(R.layout.entry_list_item, parent, false);
            holder = new Holder();
            initLayout(holder, convertView);
            convertView.setTag(holder);
        }else {
            holder = (Holder)convertView.getTag();
        }

        setData(holder, getItem(position));

        return convertView;
    }

    private void setData(Holder h, Participant item) {

        h.emblemURL.setText(item.getEmblemURL());
        h.name.setText(item.getName());
        h.imageURL.setText(item.getImageURL());
        h.operator.setText(item.getOperator());
        h.date.setText(item.getDate());
        h.assocation.setText(item.getAssociation());
    }

    private void initLayout(Holder h, View v) {

        h.emblemURL = (TextView)v.findViewById(R.id.entry_item_emblem);
        h.name = (TextView)v.findViewById(R.id.entry_item_name);
        h.imageURL = (TextView)v.findViewById(R.id.entry_item_image);
        h.operator = (TextView)v.findViewById(R.id.entry_item_operator);
        h.date = (TextView)v.findViewById(R.id.entry_item_date);
        h.assocation = (TextView)v.findViewById(R.id.entry_item_association);
    }


    class Holder {

        TextView emblemURL;
        TextView name;
        TextView imageURL;
        TextView operator;
        TextView date;
        TextView assocation;
    }
}
