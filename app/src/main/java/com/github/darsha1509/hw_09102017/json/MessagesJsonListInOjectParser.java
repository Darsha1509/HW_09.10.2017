package com.github.darsha1509.hw_09102017.json;

import com.github.darsha1509.hw_09102017.utils.IOUtils;

import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

public class MessagesJsonListInOjectParser implements IMessageListParser {

    private final InputStream mInputStream;

    public MessagesJsonListInOjectParser(InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IMessageJsonList parse() throws Exception {
        String source = IOUtils.getStringFromStream(mInputStream);

        JSONObject rootObject = new JSONObject(source);

        return new MessageJsonListInObjectWrapper(rootObject);
    }
}
