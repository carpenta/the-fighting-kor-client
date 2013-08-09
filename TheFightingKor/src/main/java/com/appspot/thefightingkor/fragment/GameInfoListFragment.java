package com.appspot.thefightingkor.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.Server.ServerInfo;
import com.appspot.thefightingkor.adapter.GameInfoListAdapter;
import com.appspot.thefightingkor.data.Game;
import com.appspot.thefightingkor.util.ResponseParser;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by mc2e on 13. 7. 14..
 */
public class GameInfoListFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private final String TAG = "GameInfoListFragment";

    @InjectView(R.id.game_list_view) ListView mListView;
    @InjectView(R.id.game_list_sorry) View mSorryView;

    private GameInfoListAdapter mAdapter;
    private ArrayList<Game> mList;

    private int position = 1;

    private String mTitle = "";

    public GameInfoListFragment(int position, String title) {
        this.position = position;
        mTitle = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        getActivity().getActionBar().setHomeButtonEnabled(true);
        getActivity().getActionBar().setTitle(mTitle);

        mList = new ArrayList<Game>();

        View v = inflater.inflate(R.layout.fragment_game_list, container, false);

        setHasOptionsMenu(true);

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Views.inject(this, view);

        mAdapter = new GameInfoListAdapter(getActivity(), mList);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);

        request();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void request() {

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
                setSorryView(false);
                displayLoading(false);
                mAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Log.e(TAG,"Server Error : "+volleyError.getLocalizedMessage());
                //Toast.makeText(getActivity(), "server do not response.", Toast.LENGTH_SHORT).show();
                setSorryView(true);
                displayLoading(false);
            }
        }));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    } //

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.sub_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_update) {
            request();
        }

        return super.onOptionsItemSelected(item);
    }

    private void setSorryView(boolean isFail) {

        if(isFail) {
            mListView.setVisibility(View.GONE);
            mSorryView.setVisibility(View.VISIBLE);
        }else {
            if(mListView.getVisibility()==View.GONE) {
                mListView.setVisibility(View.VISIBLE);
                mSorryView.setVisibility(View.GONE);
            }
        }
    }
} //
