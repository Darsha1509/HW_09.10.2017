package com.github.darsha1509.hw_09102017.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;

public class MessageTypeAdapter extends TypeAdapter {

    @Override
    public void write(final JsonWriter out, final Object value) throws IOException {

    }

    @Override
    public MessageGson read(final JsonReader in) throws IOException {
        final MessageGson message = new MessageGson();

        in.beginObject();
        while (in.hasNext()){
            switch(in.nextName()){
                case "id":
                    message.setId(in.nextInt());
                    break;
                case "date":
                    message.setDate(new Date(in.nextLong()).toString());
                    break;
                case "user_id":
                    message.setFromWhoId(in.nextInt());
                    break;
                case "body":
                    message.setMessageText(in.nextString());
                    break;
                default:
                    in.skipValue();
                    break;
            }

        }
        in.endObject();

        return message;
    }

}
