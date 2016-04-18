package com.flxn.dao.api;

import com.flxn.dao.model.Clazz;
import com.flxn.dao.model.Project;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface ClazzDao extends GenericDao<Clazz> {
     List<Clazz> getClazzByProject(Project project, int id);
     boolean exist(int id);
     boolean exist (Clazz clazz);
     String INSERT_CLAZZ="INSERT INTO \"CLASSES\"  VALUES (DEFAULT,?,?,?)";
     String UPATE_CLAZZ_BY_ID="UPDATE \"CLASSES\"  SET \"NAME\" =?,\"DESCRIPTION\"=? WHERE \"CLASS_ID\"=?";
     String SELECT_CLAZZ_BY_ID="SELECT \"NAME\",\"CLASS_ID\",\"DESCRIPTION\" FROM \"CLASSES\"  WHERE \"CLASS_ID\"=?";
     String SELECT_CLAZZ_LIST_BY_PROJECT_ID="SELECT \"CLASS_ID\",\"NAME\",\"DESCRIPTION\" FROM \"CLASSES\"  WHERE \"PROJECT_ID\"=?";
     String DELETE_CLAZZ_BY_ID="DELETE FROM \"CLASSES\" WHERE \"CLASS_ID\"=?";
     String COUNT_ID_BY_ID="SELECT COUNT(\"CLASS_ID\") FROM \"CLASSES\" WHERE  \"CLASS_ID\"=?";
     String COUNT_ID_BY_NAME_AND_PROJECT_ID="SELECT COUNT(\"CLASS_ID\") FROM \"CLASSES\" WHERE \"NAME\"=? AND \"PROJECT_ID\"=?";
}
