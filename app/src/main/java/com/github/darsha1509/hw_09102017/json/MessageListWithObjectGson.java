package com.github.darsha1509.hw_09102017.json;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

class MessageListWithObjectGson implements IMessageList{

    @SerializedName("items")
    private List<MessageGson> mMessageList;

    public List<IMessage> getMessagesList() {
        final List<IMessage> messages = new ArrayList<>();
        messages.addAll(mMessageList);
        return messages;
    }
}
