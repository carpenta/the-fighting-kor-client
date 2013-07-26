package com.appspot.thefightingkor.fragment;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.Server.ServerInfo;
import com.appspot.thefightingkor.adapter.GameInfoListAdapter;
import com.appspot.thefightingkor.data.Game;
import com.appspot.thefightingkor.loader.GameInfoServerLoader;
import com.appspot.thefightingkor.util.ResponseParser;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 7. 14..
 */
public class GameInfoListFragment extends BaseFragment {

    @InjectView(R.id.game_list_view) ListView mListView;
    @InjectView(R.id.game_list_progressbar) ProgressBar mProgress;

    private GameInfoListAdapter mAdapter;
    private ArrayList<Game> mList;

    private int position = 1;

    public GameInfoListFragment(int position) {
        this.position = position;
    }

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

        //getLoaderManager().initLoader(0, null, this);
        displayLoading(true);
        getApp().getRequestQueue().add(new StringRequest(ServerInfo.GAME_LIST_URL+position, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Log.i("GameInfoListFragment", s);
                ResponseParser parser = new ResponseParser(s);

                ArrayList<Game> result = parser.getGameList(getApp().getGSon());
                if(result != null) {
                    mList.clear();
                    mList.addAll(result);
                }
                displayLoading(false);
                mAdapter.notifyDataSetChanged();
            }
        }, null));
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
}
