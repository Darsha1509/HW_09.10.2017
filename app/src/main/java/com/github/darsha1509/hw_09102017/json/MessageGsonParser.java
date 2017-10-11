package com.github.darsha1509.hw_09102017.json;

import com.github.darsha1509.hw_09102017.utils.IOUtils;
import com.google.gson.Gson;

import java.io.InputStream;

public class MessageGsonParser implements IMessageParser {

    private final InputStream mInputStream;

    MessageGsonParser(final InputStream pInputStream){
        mInputStream=pInputStream;
    }

    @Override
    public IMessage parse() throws Exception {
        String source = IOUtils.getStringFromStream(mInputStream);
        return new Gson().fromJson(source, MessageGson.class);
    }
}
