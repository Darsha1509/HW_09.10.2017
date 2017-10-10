package com.github.darsha1509.hw_09102017.json;

import com.github.darsha1509.hw_09102017.utils.IOUtils;

import org.json.JSONObject;

import java.io.InputStream;

class MessagesJsonListInOjectParser implements IMessageListParser {

    private final InputStream mInputStream;

    MessagesJsonListInOjectParser(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IMessageJsonList parse() throws Exception {
        final String source = IOUtils.getStringFromStream(mInputStream);

        final JSONObject rootObject = new JSONObject(source);

        return new MessageJsonListInObjectWrapper(rootObject);
    }
}
