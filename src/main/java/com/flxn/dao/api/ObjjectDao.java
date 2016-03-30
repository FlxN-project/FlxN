package com.flxn.dao.api;

import com.flxn.dao.model.Clazz;
import com.flxn.dao.model.Objject;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface ObjjectDao extends  GenericDao<Objject> {
    List<Objject> getObjjectListByClazz(Clazz clazz);
}
