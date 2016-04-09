package com.roby.simplejournal;

import java.util.UUID;

/**
 * Created by Roby on 4/4/2016.
 */
public class Entry {

    private UUID id;
    private String mTitle;
    private String mText;

    public Entry(){
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
