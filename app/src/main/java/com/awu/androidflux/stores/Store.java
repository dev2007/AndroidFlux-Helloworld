package com.awu.androidflux.stores;

import com.awu.androidflux.actions.Action;
import com.squareup.otto.Bus;

/**
 * Created by yoyo on 2016/2/15.
 */
public abstract class Store {
    private static final Bus bus = new Bus();

    protected  Store(){

    }

    public void register(final Object view){
        this.bus.register(view);
    }

    public void unRegister(final Object view){
        this.bus.unregister(view);
    }

    void emitStoreChange(){
        this.bus.post(changeEvent());
    }

    public abstract StoreChangeEvent changeEvent();
    public abstract void onAction(Action action);

    public class StoreChangeEvent{}
}
