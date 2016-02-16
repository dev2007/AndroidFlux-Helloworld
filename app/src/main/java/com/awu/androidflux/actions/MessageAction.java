package com.awu.androidflux.actions;

/**
 * Created by yoyo on 2016/2/16.
 */
public class MessageAction extends Action<String> {
    public static final String ACTION_NEW_MESSAGE = "new_message";

    MessageAction(String type, String data) {
        super(type, data);
    }
}
