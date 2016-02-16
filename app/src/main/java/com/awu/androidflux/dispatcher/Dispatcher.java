package com.awu.androidflux.dispatcher;

import com.awu.androidflux.actions.Action;
import com.awu.androidflux.stores.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoyo on 2016/2/16.
 */
public class Dispatcher {
    private static Dispatcher instance;
    private final List<Store> stores = new ArrayList<>();

    public static Dispatcher get(){
        if(instance == null){
            instance = new Dispatcher();
        }
        return instance;
    }

    Dispatcher(){

    }

    public void register(final Store store){
        stores.add(store);
    }

    public void unregister(final Store store){
        stores.remove(store);
    }

    public void dispatcher(Action action){
        post(action);
    }

    private void post(final Action action){
        for (Store store:stores){
            store.onAction(action);
        }
    }
}
