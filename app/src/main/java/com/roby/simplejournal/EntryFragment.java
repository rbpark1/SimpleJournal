package com.roby.simplejournal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Roby on 4/4/2016.
 */
public class EntryFragment extends Fragment{

    private static final String ARG_ENTRY_ID = "entry_id";

    private Entry mEntry;
    private EditText mTitleField;

    public static EntryFragment newInstance(UUID entryId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_ENTRY_ID, entryId);
        EntryFragment fragment = new EntryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID entryId = (UUID) getArguments().getSerializable(ARG_ENTRY_ID);
        mEntry = EntryLab.get(getActivity()).getEntry(entryId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_entry, container, false);

        mTitleField = (EditText) v.findViewById(R.id.titleEditText);
        mTitleField.setText(mEntry.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEntry.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //do nothing
            }
        });

        return v;
    }
}
