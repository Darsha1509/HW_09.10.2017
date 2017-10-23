package com.github.darsha1509.hw_09102017.json;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

class MessageGson implements IMessage{

    @SerializedName("id")
    private long mId;

    @SerializedName("user_id")
    private long mFromWhoId;

    @SerializedName("body")
    private String mMessageText;

    @SerializedName("date")
    private String mDate;

    @Override
    public long getId() {
        return mId;
    }

    @Override
    public long getFromWhoId() {
        return mFromWhoId;
    }

    @Override
    public String getMessageText() {
        return mMessageText;
    }

    @Override
    public String getDate() {
        return  mDate;
    }

    public void setDate(String pDate) {
        mDate = pDate;
    }

    public void setId(long pId) {
        mId = pId;
    }

    public void setFromWhoId(long pFromWhoId) {
        mFromWhoId = pFromWhoId;
    }

    public void setMessageText(String pMessageText) {
        mMessageText = pMessageText;
    }
}
