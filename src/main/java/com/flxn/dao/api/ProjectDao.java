package com.flxn.dao.api;

import com.flxn.dao.model.Project;
import com.flxn.dao.model.User;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface ProjectDao extends  GenericDao<Project> {
     boolean exist(Project project);
     boolean exist(int id);
     List<Project> getProjectListByUser(User user);
     String INSERT_PROJECT="INSERT INTO \"PROJECTS\" VALUES(DEFAULT,?,?,?)";
     String UPDATE_PROJECT_BY_ID="UPDATE \"PROJECTS\" SET \"TITLE\"=?,\"DESCRIPTION\"=? WHERE \"PROJECT_ID\"=?";
     String SELECT_PROJECT_BY_ID="SELECT \"TITLE\",\"PROJECT_ID\",\"DESCRIPTION\" FROM \"PROJECTS\"  WHERE \"PROJECT_ID\"=?";
     String SELECT_PROJECT_LIST_BY_USER_ID="SELECT \"PROJECT_ID\",\"TITLE\",\"DESCRIPTION\" FROM \"PROJECTS\"  WHERE \"USER_ID\"=?";
     String DELETE_PROJECT_BY_ID="DELETE FROM \"PROJECTS\" WHERE \"PROJECT_ID\"=?";
     String SELECT_COUNT_ID_BY_ID="SELECT COUNT(\"PROJECT_ID\") FROM \"PROJECTS\" WHERE  \"PROJECT_ID\"=?";
     String SELECT_COUNT_ID_BY_TITLE_AND_USER="SELECT COUNT(\"PROJECT_ID\") FROM \"PROJECTS\" WHERE \"TITLE\"=? AND \"USER_ID\"=?";
}
