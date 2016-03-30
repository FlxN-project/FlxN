package com.flxn.dao.api;

import com.flxn.dao.model.Project;
import com.flxn.dao.model.User;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface ProjectDao extends  GenericDao<Project> {
     List<Project> getProjectListByUser(User user);
}
