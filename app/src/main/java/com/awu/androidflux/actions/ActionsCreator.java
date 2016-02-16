package com.awu.androidflux.actions;

import com.awu.androidflux.dispatcher.Dispatcher;

/**
 * Created by yoyo on 2016/2/16.
 */
public class ActionsCreator {
    private static ActionsCreator instance;
    final Dispatcher dispatcher;

    ActionsCreator(Dispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    public static ActionsCreator get(Dispatcher dispatcher){
        if(instance == null){
            instance = new ActionsCreator(dispatcher);
        }
        return instance;
    }

    public void sendMessage(String message){
        dispatcher.dispatcher(new MessageAction(MessageAction.ACTION_NEW_MESSAGE,message));
    }

}
