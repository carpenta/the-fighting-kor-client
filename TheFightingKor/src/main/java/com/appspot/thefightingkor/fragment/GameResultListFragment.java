package com.appspot.thefightingkor.fragment;

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
import com.appspot.thefightingkor.adapter.GameResultListAdapter;
import com.appspot.thefightingkor.data.Game;
import com.appspot.thefightingkor.data.GameResultListInfo;
import com.appspot.thefightingkor.util.ResponseParser;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 8. 6..
 */
public class GameResultListFragment extends BaseFragment {

    @InjectView(R.id.game_result_list_view)
    ListView mListView;

    private GameResultListAdapter mAdapter;

    private ArrayList<GameResultListInfo> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        getActivity().getActionBar().setHomeButtonEnabled(true);

        return inflater.inflate(R.layout.fragment_game_result_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Views.inject(this, view);

        mList = new ArrayList<GameResultListInfo>();

        mAdapter = new GameResultListAdapter(getActivity(), mList);

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

    private void request() {

        //displayLoading(true);
        getApp().getRequestQueue().add(new StringRequest(ServerInfo.GAME_RESULT_LIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                ResponseParser parser = new ResponseParser(s);

                ArrayList<Game> result = parser.getGameList(getApp().getGSon());
                if(result != null) {
                    mList.clear();
           //         mList.addAll(result);
                }
          //      displayLoading(false);
                mAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

              //  Log.e(TAG,"Server Error : "+volleyError.getLocalizedMessage());
                Toast.makeText(getActivity(), "server do not response.", Toast.LENGTH_SHORT).show();
            //    displayLoading(false);
            }
        }));
    }
}
