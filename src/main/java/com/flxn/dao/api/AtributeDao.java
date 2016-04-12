package com.flxn.dao.api;

import com.flxn.dao.model.Atribute;
import com.flxn.dao.model.Clazz;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface AtributeDao extends  GenericDao<Atribute> {
    List<Atribute> getAtributeListByClazz(Clazz clazz);
    String INSERT_ATRIBUTE="INSERT INTO \"ATTRIBUTES\"  VALUES (DEFAULT,?,?);";
    String UPDATE_ATRIBUTE_BY_ID="UPDATE \"ATTRIBUTES\"  SET \"NAME\"= ? WHERE \"ATTRIBUTE_ID\"=?;";
    String DELETE_ATRIBUTE_BY_ID="DELETE FROM \"ATTRIBUTES\" WHERE \"ATTRIBUTE_ID\"=?;";
    String SELECT_ATRIBUTE_BY_ID="SELECT \"NAME\",\"CLASS_ID\" FROM  \"ATTRIBUTES\" WHERE \"ATTRIBUTE_ID\"=?;";
    String SELECT_ATRIBUTE_LIST_BY_CLAZZ_ID="SELECT \"OBJECT_ID\",\"NAME\" FROM  \"ATTRIBUTES\" WHERE \"CLASS_ID\"=?;";
}
