package com.github.darsha1509.hw_09102017.json;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class RootObjectForGsonList {

    @SerializedName("response")
    private MessageListWithObjectGson mResponse;

    MessageListWithObjectGson getResponse(){
        return  mResponse;
    }
}
