package com.awu.androidflux.stores;

import android.os.Message;

import com.awu.androidflux.actions.Action;

/**
 * Created by yoyo on 2016/2/16.
 */
public class MessageStore extends Store {
    private static MessageStore singleton;
    private String message;

    public MessageStore(){
        super();
    }

    public String getMessage(){
        return message;
    }

    @Override
    public StoreChangeEvent changeEvent() {
        return new StoreChangeEvent();
    }

    @Override
    public void onAction(Action action) {
        message = (String)action.getData();
        emitStoreChange();
    }
}
