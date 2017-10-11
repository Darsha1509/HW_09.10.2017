package com.github.darsha1509.hw_09102017.json;

import com.github.darsha1509.hw_09102017.utils.IOUtils;
import com.google.gson.Gson;

import java.io.InputStream;

public class MessageListWithObjectGsonParser implements IMessageListParser {

    private InputStream mInputStream;

    public MessageListWithObjectGsonParser(InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IMessageList parse() throws Exception {
        String source =IOUtils.getStringFromStream(mInputStream);
        return new Gson().fromJson(source, RootObjectForGsonList.class).getResponse();
    }
}
