package com.flxn.dao.api;

import com.flxn.dao.model.Atribute;
import com.flxn.dao.model.Clazz;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface AtributeDao extends  GenericDao<Atribute> {
    List<Atribute> getAtributeListByClazz(Clazz clazz);
}
