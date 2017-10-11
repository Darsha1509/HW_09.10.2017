package com.github.darsha1509.hw_09102017.json;

import java.util.ArrayList;
import java.util.List;

public class MessageListGson implements IMessageList {

    private final List<MessageGson> mMessageList;

    public MessageListGson(final List<MessageGson> pMessageList) {
        mMessageList = pMessageList;
    }

    @Override
    public List<IMessage> getMessagesList() {
        List<IMessage> messages = new ArrayList<>();
        messages.addAll(mMessageList);
        return messages;
    }
}
