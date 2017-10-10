package com.github.darsha1509.hw_09102017.json;

import com.github.darsha1509.hw_09102017.utils.IOUtils;

import org.json.JSONObject;

import java.io.InputStream;

class MessageJSONParser implements IMessageParser {

    private final InputStream mInputStream;

    MessageJSONParser(final InputStream pSource) {
        mInputStream = pSource;
    }

    @Override
    public IMessage parse() throws Exception {
        final String source = IOUtils.getStringFromStream(mInputStream);

        final JSONObject jsonObject = new JSONObject(source);

        return new MessageJSONWrapper(jsonObject);
    }
}
