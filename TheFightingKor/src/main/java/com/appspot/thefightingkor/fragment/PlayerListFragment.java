package com.appspot.thefightingkor.fragment;

import android.app.Activity;
import android.support.v4.app.LoaderManager.*;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.Server.ServerInfo;
import com.appspot.thefightingkor.adapter.PlayerListAdapter;
import com.appspot.thefightingkor.data.Player;
import com.appspot.thefightingkor.loader.PlayerServerLoader;
import com.appspot.thefightingkor.util.ResponseParser;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 6. 22..
 */
public class PlayerListFragment extends BaseFragment {

    private final String TAG = "PlayerListFragment";

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
        displayLoading(true);
        getApp().getRequestQueue().add(new StringRequest(ServerInfo.PLAYER_LIST_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Log.i("PlayerListFragment", s);
                ResponseParser parser = new ResponseParser(s);

                ArrayList<Player> result = parser.getPlayerList(getApp().getGSon());
                if(result != null) {
                    mList.clear();
                    mList.addAll(result);
                }
                displayLoading(false);
                mAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Log.e(TAG,"Server Error : "+volleyError.getLocalizedMessage());

                Toast.makeText(getActivity(), "server do not response.", Toast.LENGTH_SHORT).show();
                displayLoading(false);
            }
        }));
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
