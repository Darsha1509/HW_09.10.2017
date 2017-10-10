package com.github.darsha1509.hw_09102017.json;

import java.io.InputStream;

class MessageParserFactory {

    IMessageParser createParser(final InputStream pSourse){
        return  new MessageJSONParser(pSourse);
    }
}
