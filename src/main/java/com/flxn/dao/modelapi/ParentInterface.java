package com.flxn.dao.modelapi;

/**
 * Created by X8 on 17.04.2016.
 */
public interface ParentInterface<T> extends  ModelInterface {
    T getParent();
    void setParent(T object);

}
