package com.roby.simplejournal;

import android.support.v4.app.Fragment;

/**
 * Created by Roby on 4/5/2016.
 */
public class EntryListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new EntryListFragment();
    }
}
