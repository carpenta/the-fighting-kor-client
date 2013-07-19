package com.appspot.thefightingkor.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.activity.IntroAcitity;
import com.appspot.thefightingkor.adapter.MainListAdapter;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 7. 13..
 */
public class MainFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    @InjectView(R.id.main_list_view) ListView mListView;

    private MainListAdapter mAdapter;

    private ArrayList<String> mArenaName;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        getActivity().getActionBar().setDisplayHomeAsUpEnabled(false);
        getActivity().getActionBar().setHomeButtonEnabled(false);

        String[] array = getActivity().getResources().getStringArray(R.array.main_manu_array);

        mArenaName = new ArrayList<String>();

        for(String name : array) {
            mArenaName.add(name);
        }

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle bundle) {
        super.onViewCreated(v, bundle);

        Views.inject(this, v);

        mListView.setOnItemClickListener(this);
        mAdapter = new MainListAdapter(getActivity(), mArenaName);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {

        if(pos == 0) {

            executeFragmet(GAME_TAG);
        }else if(pos == 4) {
            executeFragmet(ENTRY_TAG);
        }
    }
}
