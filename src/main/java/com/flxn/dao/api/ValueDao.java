package com.flxn.dao.api;

import com.flxn.dao.model.Atribute;
import com.flxn.dao.model.Objject;
import com.flxn.dao.model.Value;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface ValueDao extends GenericDao<Value> {
    List<Value> getValueListByObjject(Objject objject);
    List<Value> getValueListByAtribute(Atribute atribute);
}
