package com.github.darsha1509.hw_09102017.json;

import com.github.darsha1509.hw_09102017.utils.IOUtils;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.Arrays;

public class MessageListGsonParser implements IMessageListParser {

    private final InputStream mInputStream;

    public MessageListGsonParser(InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IMessageList parse() throws Exception {
        String source = IOUtils.getStringFromStream(mInputStream);
        MessageGson[] result = new Gson().fromJson(source, MessageGson[].class);
        return new MessageListGson(Arrays.asList(result));
    }
}
