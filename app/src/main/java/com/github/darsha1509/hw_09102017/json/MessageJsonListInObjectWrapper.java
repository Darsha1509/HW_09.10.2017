package com.github.darsha1509.hw_09102017.json;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MessageJsonListInObjectWrapper implements IMessageJsonList {

    private static final String LOG_TAG = MessageJsonListInObjectWrapper.class.getSimpleName();

    private static final String RESPONSE_OBJECT = "response";
    private static final String MASSAGE_ARRAY = "items";

    private final JSONObject mJSONObject;

    public MessageJsonListInObjectWrapper(JSONObject pJSONObject) {
        mJSONObject = pJSONObject;
    }

    @Override
    public List<MessageJSONWrapper> getMessagesJsonList() {
        JSONObject response = null;
        try {
            response = mJSONObject.getJSONObject(RESPONSE_OBJECT);

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Error with parse response object");
        }
        JSONArray jsonArray = response.optJSONArray(MASSAGE_ARRAY);
        List<MessageJSONWrapper> messages = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                MessageJSONWrapper mes = new MessageJSONWrapper(jsonObject);
                messages.add(mes);
            } catch (JSONException e) {
                Log.e(LOG_TAG, "Error with jsonArray");
            }
        }
        return messages;
    }
}
