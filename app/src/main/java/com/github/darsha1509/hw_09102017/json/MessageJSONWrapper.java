package com.github.darsha1509.hw_09102017.json;

import org.json.JSONObject;

import java.util.Date;

public class MessageJSONWrapper implements IMessage{

    private static final String ID="id";
    private static final String FROM_WHO_ID="user_id";
    private static final String MESSAGE_TEXT="body";
    private static final String DATE="date";

    private final JSONObject mJSONObject;

    public MessageJSONWrapper(final JSONObject pJSONObject) {
        mJSONObject = pJSONObject;
    }

    @Override
    public long getId() {
        return mJSONObject.optLong(ID);
    }

    @Override
    public long getFromWhoId() {
        return mJSONObject.optLong(FROM_WHO_ID);
    }

    @Override
    public String getMessageText() {
        return mJSONObject.optString(MESSAGE_TEXT);
    }

    @Override
    public String getDate() {

        return new Date(mJSONObject.optLong(DATE)).toString();
    }
}
