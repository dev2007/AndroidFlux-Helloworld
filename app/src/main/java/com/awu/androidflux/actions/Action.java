package com.awu.androidflux.actions;

/**
 * Created by yoyo on 2016/2/16.
 */
public class Action<T> {
    private final String type;
    private final T data;

    Action(String type,T data){
        this.type = type;
        this.data = data;
    }

    public String getType(){
        return type;
    }

    public T getData(){
        return data;
    }
}
