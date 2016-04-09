package com.roby.simplejournal;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class EntryActivity extends SingleFragmentActivity {

    private static final String EXTRA_ENTRY_ID = "com.roby.simplejournal.entry_id";

    public static Intent newIntent(Context packageContext, UUID entryId){
        Intent intent = new Intent(packageContext, EntryActivity.class);
        intent.putExtra(EXTRA_ENTRY_ID, entryId);
        return intent;
    }

    protected Fragment createFragment(){
        UUID id = (UUID) getIntent()
                .getSerializableExtra(EXTRA_ENTRY_ID);
        return EntryFragment.newInstance(id);
    }

}
