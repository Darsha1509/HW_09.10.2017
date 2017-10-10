package com.github.darsha1509.hw_09102017.json;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class MessageJSONParser implements IMessageParser {

    private final InputStream mInputStream;

    MessageJSONParser(final InputStream pSource) {
        mInputStream = pSource;
    }

    @Override
    public IMessage parse() throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(mInputStream));

        final StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }
        final String source = sb.toString();

        br.close();

        final JSONObject jsonObject = new JSONObject(source);

        return new MessageJSONWrapper(jsonObject);
    }
}
