package com.github.darsha1509.hw_09102017.json;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class MessageListWrapper implements IMessageList {

    private static final String LOG_TAG = MessageListWrapper.class.getSimpleName();

    private final JSONArray mJSONArray;

    MessageListWrapper(final JSONArray pJSONArray) {
        mJSONArray = pJSONArray;
    }

    @Override
    public List<IMessage> getMessagesList() {
        final List<MessageJSONWrapper> messages = new ArrayList<>();
        for (int i = 0; i < mJSONArray.length(); i++) {
            try {
                final JSONObject jsonObject = mJSONArray.getJSONObject(i);
                final MessageJSONWrapper mes = new MessageJSONWrapper(jsonObject);
                messages.add(mes);
            } catch (final JSONException e) {
                Log.e(LOG_TAG, "Error with jsonArray");
            }
        }

        List<IMessage> messagesArray  = new ArrayList<>();
        messagesArray.addAll(messages);
        return messagesArray;
    }
}
