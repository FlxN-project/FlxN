package com.flxn.dao.api;

/**
 * Created by X8 on 29.03.2016.
 */
public interface GenericDao<T>  {
     T create();//Создать обьект и запись
     T persist(T object); // запись по обьекту
     void delete(T object);
     void update(T object);
     T getById(int id);
}
