package com.flxn.dao.api;

import com.flxn.dao.model.Clazz;
import com.flxn.dao.model.Objject;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface ObjjectDao extends  GenericDao<Objject> {
    boolean exist (int id);
    boolean exist (Objject objject);
    List<Objject> getObjjectListByClazz(Clazz clazz, int id);
    String INSERT_OBJJECT="INSERT INTO \"OBJECTS\"  VALUES (DEFAULT,?,?)";
    String UPDATE_OBJJECT_BY_ID="UPDATE \"OBJECTS\"  SET \"LINK\"= ? WHERE \"OBJECT_ID\"=?";
    String DELETE_OBJJECT_BY_ID="DELETE FROM \"OBJECTS\" WHERE \"OBJECT_ID\"=?";
    String SELECT_OBJJECT_BY_ID="SELECT \"LINK\",\"OBJECT_ID\" FROM  \"OBJECTS\" WHERE \"OBJECT_ID\"=?";
    String SELECT_OBJJECT_LIST_BY_CLAZZ_ID="SELECT \"OBJECT_ID\",\"LINK\" FROM  \"OBJECTS\" WHERE \"CLASS_ID\"=?";
    String COUNT_ID_BY_ID="SELECT COUNT(\"OBJECT_ID\") FROM \"OBJECTS\" WHERE  \"OBJECT_ID\"=?";
    String COUNT_ID_BY_NAME_AND_CLAZZ_ID="SELECT COUNT(\"OBJECT_ID\") FROM \"OBJECTS\" WHERE \"LINK\"=? AND \"CLASS_ID\"=?";
}
