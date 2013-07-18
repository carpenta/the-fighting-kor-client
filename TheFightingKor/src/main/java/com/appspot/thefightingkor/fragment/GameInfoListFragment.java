package com.appspot.thefightingkor.fragment;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.adapter.GameInfoListAdapter;
import com.appspot.thefightingkor.data.Game;
import com.appspot.thefightingkor.loader.GameInfoServerLoader;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 7. 14..
 */
public class GameInfoListFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<ArrayList<Game>>{

    @InjectView(R.id.game_list_view) ListView mListView;
    @InjectView(R.id.game_list_progressbar) ProgressBar mProgress;

    private GameInfoListAdapter mAdapter;
    private ArrayList<Game> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        getActivity().getActionBar().setHomeButtonEnabled(true);

        mList = new ArrayList<Game>();

        View v = inflater.inflate(R.layout.fragment_game_list, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Views.inject(this, view);

        mAdapter = new GameInfoListAdapter(getActivity(), mList);
        mListView.setAdapter(mAdapter);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public Loader<ArrayList<Game>> onCreateLoader(int i, Bundle bundle) {

        displayLoading(true);

        return new GameInfoServerLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Game>> arrayListLoader, ArrayList<Game> games) {

        if(games != null) {
            if(mList != null) {
                mList.clear();
            }
            mList.addAll(games);
        }
        displayLoading(false);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Game>> arrayListLoader) {

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
}
