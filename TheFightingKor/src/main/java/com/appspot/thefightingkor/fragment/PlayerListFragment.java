package com.appspot.thefightingkor.fragment;

import android.app.Activity;
import android.support.v4.app.LoaderManager.*;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.adapter.PlayerListAdapter;
import com.appspot.thefightingkor.data.Player;
import com.appspot.thefightingkor.loader.PlayerServerLoader;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 6. 22..
 */
public class PlayerListFragment extends BaseFragment implements LoaderCallbacks<ArrayList<Player>> {

    @InjectView(R.id.player_list_view) ListView mListView;

    @InjectView(R.id.player_list_progressbar) ProgressBar mProgress;

    private PlayerListAdapter mAdapter;

    private ArrayList<Player> mList;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        View view = inflater.inflate(R.layout.fragment_player_list, container, false);

        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        getActivity().getActionBar().setHomeButtonEnabled(true);

        mList = new ArrayList<Player>();

        return view;
    }

    @Override
    public void onViewCreated(View v, Bundle bundle) {
        super.onViewCreated(v, bundle);
        Views.inject(this, v);

        mAdapter = new PlayerListAdapter(getActivity(), mList);

        mListView.setAdapter(mAdapter);
        // start AsyncTaskLoader
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    private void displayLoading(boolean show) {

        if(mProgress == null)
            return;

        if(show) {
            if(mProgress.getVisibility() == View.GONE)
                mProgress.setVisibility(View.VISIBLE);
        }else {

            if(mProgress.getVisibility() == View.VISIBLE)
                mProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public Loader<ArrayList<Player>> onCreateLoader(int i, Bundle bundle) {

        displayLoading(true);

        return new PlayerServerLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Player>> arrayListLoader, ArrayList<Player> players) {

        if(players != null) {
            if(mList != null)
                mList.clear();

            mList.addAll(players);

            mAdapter.notifyDataSetChanged();
        }
        displayLoading(false);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Player>> arrayListLoader) {

    }
}
