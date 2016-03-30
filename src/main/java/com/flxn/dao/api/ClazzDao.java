package com.flxn.dao.api;

import com.flxn.dao.model.Clazz;
import com.flxn.dao.model.Project;

import java.util.List;

/**
 * Created by X8 on 29.03.2016.
 */
public interface ClazzDao extends GenericDao<Clazz> {
     List<Clazz> getClazzByProject(Project project);
}
