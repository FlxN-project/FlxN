package com.flxn.dao.api;

import com.flxn.dao.model.Atribute;
import com.flxn.dao.model.Clazz;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface AtributeDao extends  GenericDao<Atribute> {
    boolean exist(int id);
    boolean exist(Atribute atribute);
    List<Atribute> getAtributeListByClazz(Clazz clazz, int id);
    String INSERT_ATRIBUTE="INSERT INTO \"ATTRIBUTES\"  VALUES (DEFAULT,?,?)";
    String UPDATE_ATRIBUTE_BY_ID="UPDATE \"ATTRIBUTES\"  SET \"NAME\"= ? WHERE \"ATTRIBUTE_ID\"=?";
    String DELETE_ATRIBUTE_BY_ID="DELETE FROM \"ATTRIBUTES\" WHERE \"ATTRIBUTE_ID\"=?";
    String SELECT_ATRIBUTE_BY_ID="SELECT \"NAME\",\"ATTRIBUTE_ID\" FROM  \"ATTRIBUTES\" WHERE \"ATTRIBUTE_ID\"=?";
    String SELECT_ATRIBUTE_LIST_BY_CLAZZ_ID="SELECT \"ATTRIBUTE_ID\",\"NAME\" FROM  \"ATTRIBUTES\" WHERE \"CLASS_ID\"=?";
    String COUNT_ID_BY_ID="SELECT COUNT(\"ATTRIBUTE_ID\") FROM \"ATTRIBUTES\" WHERE  \"ATTRIBUTE_ID\"=?";
    String COUNT_ID_BY_NAME_AND_CLAZZ_ID="SELECT COUNT(\"ATTRIBUTE_ID\") FROM \"ATTRIBUTES\" WHERE \"NAME\"=? AND \"CLASS_ID\"=?";
}
