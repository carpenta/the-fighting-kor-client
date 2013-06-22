package com.appspot.thefightingkor.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.appspot.thefightingkor.R;
import com.appspot.thefightingkor.adapter.EntryListAdapter;
import com.appspot.thefightingkor.data.Participant;
import com.appspot.thefightingkor.task.ServerTask;
import com.appspot.thefightingkor.task.callback.ServerTaskCallback;

import java.util.ArrayList;

/**
 * Created by mc2e on 13. 6. 22..
 */
public class EntryListFragment extends BaseFragment implements ServerTaskCallback {

    private ListView mListView;

    private EntryListAdapter mAdapter;

    private ArrayList<Participant> mList;

    private ServerTask mServerTask;

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

        executeServerTask();
    }

    @Override
    public void onPause() {
        super.onPause();

        stopServerTasek();
    }

    private void executeServerTask() {

        stopServerTasek();
        displayLoading(true);

        mServerTask = new ServerTask(this);

        mServerTask.execute();
    }

    private void stopServerTasek() {

        if(mServerTask != null)
            mServerTask.cancel(true);

        mServerTask = null;
    }


    @Override
    public void onTaskCompleted(Object obj) {

        if(obj != null) {
            if(mList != null)
                mList.clear();

            mList.addAll((ArrayList<Participant>)obj);

            mAdapter.notifyDataSetChanged();
        }
        displayLoading(false);
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
