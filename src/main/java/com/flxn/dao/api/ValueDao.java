package com.flxn.dao.api;

import com.flxn.dao.model.Atribute;
import com.flxn.dao.model.Objject;
import com.flxn.dao.model.Value;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface ValueDao extends GenericDao<Value> {
    boolean exist(int id);
    boolean exist (Value value);
    List<Value> getValueListByObjject(Objject objject, int id);
    List<Value> getValueListByAtribute(Atribute atribute);
    String INSERT_VALUE="INSERT INTO \"VALUES\"  VALUES (DEFAULT,?,?,?)";
    String UPDATE_VALUE_BY_ID="UPDATE \"VALUES\"  SET \"VALUE\" =? WHERE \"ATTRIBUTE_ID\"=? AND \"OBJECT_ID\"=? ";
    String SELECT_VALUE_BY_ID="SELECT \"VALUE\",\"ATTRIBUTE_ID\",\"OBJECT_ID\" FROM \"VALUES\"  WHERE \"VALUE_ID\"=?";
    String SELECT_VALUE_LIST_BY_OBJJECT_ID="SELECT \"VALUE\",\"ATTRIBUTE_ID\",\"VALUE_ID\" FROM \"VALUES\"  WHERE \"OBJECT_ID\"=?";
    String SELECT_VALUE_LIST_BY_ATRIBUTE_ID="SELECT \"VALUE\",\"NAME\",\"DESCRIPTION\" FROM \"VALUES\"  WHERE \"ATTRIBUTE_ID\"=?";
    String DELETE_VALUE_BY_ID="DELETE FROM \"VALUES\" WHERE \"VALUE_ID\"=?";
    String COUNT_ID_BY_ID="SELECT COUNT(\"VALUE_ID\") FROM \"VALUES\" WHERE  \"VALUE_ID\"=?";
    String COUNT_ID_BY_ATRIBUTE_ID_AND_OBJJECT_ID="SELECT COUNT(\"VALUE_ID\") FROM \"VALUES\" WHERE \"ATTRIBUTE_ID\"=? AND \"OBJECT_ID\"=?";

}
