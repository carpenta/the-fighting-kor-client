package com.appspot.thefightingkor.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.Server.ServerInfo;
import com.appspot.thefightingkor.adapter.GameResultInfoAdapter;
import com.appspot.thefightingkor.data.GameResultInfo;
import com.appspot.thefightingkor.data.Player;
import com.appspot.thefightingkor.util.ResponseParser;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 6. 22..
 */
public class GameResultInfoFragment extends BaseFragment {

    private final String TAG = "PlayerListFragment";

    @InjectView(R.id.player_list_view) ListView mListView;

    private GameResultInfoAdapter mAdapter;

    private ArrayList<Player> mList;

    private String id = "";

    public GameResultInfoFragment(String id) {

        this.id = id;
    }


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

        mAdapter = new GameResultInfoAdapter(getActivity(), mList);

        mListView.setAdapter(mAdapter);
        displayLoading(true);
        getApp().getRequestQueue().add(new StringRequest(ServerInfo.GAME_RESULT_INFO+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Log.i("GameResultInfoFragment", s);
                ResponseParser parser = new ResponseParser(s);

                GameResultInfo info = parser.getGameResultInfo(getApp().getGSon());

                getActivity().getActionBar().setTitle(info.getTournamentName());

                if(info != null) {
                    mList.clear();

                    mList.add(info.getGold());
                    mList.add(info.getSilver());
                    mList.add(info.getBronze1());
                    mList.add(info.getBronze2());
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
}
