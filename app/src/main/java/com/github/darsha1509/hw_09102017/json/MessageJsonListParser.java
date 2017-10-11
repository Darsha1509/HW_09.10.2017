package com.github.darsha1509.hw_09102017.json;

import com.github.darsha1509.hw_09102017.utils.IOUtils;

import org.json.JSONArray;

import java.io.InputStream;

class MessageJsonListParser implements IMessageListParser {

    private final InputStream mInputStream;

    MessageJsonListParser(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IMessageList parse() throws Exception {
        final String source = IOUtils.getStringFromStream(mInputStream);

        final JSONArray rootArray = new JSONArray(source);

        return new MessageListWrapper(rootArray);

    }
}
