package com.flxn.dao.api;

import com.flxn.dao.model.Project;
import com.flxn.dao.model.User;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface ProjectDao extends  GenericDao<Project> {
     List<Project> getProjectListByUser(User user);
     String INSERT_PROJECT="INSERT INTO \"PROJECTS\" VALUES(DEFAULT,?,?,?);";
     String UPDATE_PROJECT_BY_ID="UPDATE \"PROJECTS\" SET \"TITLE\"=?,\"DESCRIPTION\"=? WHERE \"PROJECT_ID\"=2;";
     String SELECT_PROJECT_BY_ID="SELECT \"TITLE\",\"USER_ID\",\"DESCRIPTION\" FROM \"PROJECTS\"  WHERE \"PROJECT_ID\"=?;";
     String SELECT_PROJEC_TLIST_BY_USER_ID="SELECT \"PROJECT_ID\",\"TITLE\",\"DESCRIPTION\" FROM \"PROJECTS\"  WHERE \"USER_ID\"=?;";
     String DELETE_PROJECT_BY_ID="DELETE FROM \"PROJECTS\" WHERE \"PROJECT_ID\"=?;";
}
