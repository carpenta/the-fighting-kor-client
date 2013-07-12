package com.appspot.thefightingkor.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.adapter.EntryListAdapter;
import com.appspot.thefightingkor.data.Participant;
import com.appspot.thefightingkor.loader.ServerLoader;

import java.util.ArrayList;

/**
 * Created by mc2e on 13. 6. 22..
 */
public class EntryListFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<ArrayList<Participant>> {

    private ListView mListView;

    private EntryListAdapter mAdapter;

    private ArrayList<Participant> mList;

    private ProgressBar mProgress;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        mList = new ArrayList<Participant>();

        return inflater.inflate(R.layout.fragment_entry_list, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle bundle) {
        super.onViewCreated(v, bundle);

        mProgress = (ProgressBar)v.findViewById(R.id.entry_list_progressbar);

        mListView = (ListView)v.findViewById(R.id.entry_list_view);
        mAdapter = new EntryListAdapter(getActivity(), mList);

        mListView.setAdapter(mAdapter);

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
    public Loader<ArrayList<Participant>> onCreateLoader(int i, Bundle bundle) {

        displayLoading(true);

        return new ServerLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Participant>> arrayListLoader, ArrayList<Participant> participants) {

        if(participants != null) {
            if(mList != null)
                mList.clear();

            mList.addAll(participants);

            mAdapter.notifyDataSetChanged();
        }
        displayLoading(false);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Participant>> arrayListLoader) {

    }
}
