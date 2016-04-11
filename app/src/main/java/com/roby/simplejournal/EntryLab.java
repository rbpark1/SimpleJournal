package com.roby.simplejournal;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Roby on 4/5/2016.
 */
public class EntryLab {
    private static EntryLab sEntryLab;

    private List<Entry> mEntries;

    public static EntryLab get(Context context){
        if(sEntryLab == null){
            sEntryLab = new EntryLab(context);
        }
        return sEntryLab;
    }

    private EntryLab(Context context){
        mEntries = new ArrayList<>();
        //generate test entries
        for(int i = 1; i <= 30; i++){
            Entry entry = new Entry();
            entry.setTitle("Entry " + i);
            entry.setText("This is entry number " + i);
            mEntries.add(entry);
        }
    }

    public List<Entry> getEntries() {
        return mEntries;
    }

    public Entry getEntry(UUID id){
        for(Entry entry: mEntries){
            if(entry.getId().compareTo(id)==0){
                return entry;
            }
        }
        return null;
    }
}
