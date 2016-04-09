package com.roby.simplejournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Roby on 4/5/2016.
 */
public class EntryListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private EntryAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_entry_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.entry_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        EntryLab entryLab = EntryLab.get(getActivity());
        List<Entry> entries = entryLab.getEntries();
        mAdapter = new EntryAdapter(entries);
        mRecyclerView.setAdapter(mAdapter);
    }

    //inner class
    private class EntryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleTextView;
        private Entry mEntry;

        public EntryViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView;
        }

        public void bindEntry(Entry entry){
            mEntry = entry;
            mTitleTextView.setText(mEntry.getTitle());
        }

        @Override
        public void onClick(View v){
            Intent intent = EntryActivity.newIntent(getActivity(), mEntry.getId());
            startActivity(intent);
        }

    }

    //inner class
    private class EntryAdapter extends RecyclerView.Adapter<EntryViewHolder>{

        private List<Entry> mEntries;

        public EntryAdapter(List<Entry> entries){
            mEntries = entries;
        }

        @Override
        public EntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new EntryViewHolder(view);
        }

        @Override
        public void onBindViewHolder(EntryViewHolder viewHolder, int position){
            Entry entry = mEntries.get(position);
            viewHolder.bindEntry(entry);
        }

        @Override
        public int getItemCount(){
            return mEntries.size();
        }

    }

}
