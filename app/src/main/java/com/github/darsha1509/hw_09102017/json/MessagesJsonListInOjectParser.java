package com.github.darsha1509.hw_09102017.json;

import android.util.Log;

import com.github.darsha1509.hw_09102017.utils.IOUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

class MessagesJsonListInOjectParser implements IMessageListParser {

    private static final String LOG_TAG = MessagesJsonListInOjectParser.class.getSimpleName();

    private final InputStream mInputStream;

    private static final String RESPONSE_OBJECT = "response";
    private static final String MASSAGE_ARRAY = "items";

    MessagesJsonListInOjectParser(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IMessageList parse() throws Exception {
        final String source = IOUtils.getStringFromStream(mInputStream);

        final JSONObject rootObject = new JSONObject(source);

        JSONObject response = null;

        try {
            response = rootObject.getJSONObject(RESPONSE_OBJECT);

        } catch (final JSONException e) {
            Log.e(LOG_TAG, "Error with parse response object");
        }
        assert response != null;
        final JSONArray jsonArray = response.optJSONArray(MASSAGE_ARRAY);

        return new MessageListWrapper(jsonArray);
    }
}
