package com.flxn.service.api;

import com.flxn.dao.model.Project;
import com.flxn.dao.model.User;
import com.flxn.service.logic.DeferredResponse;

import java.util.List;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
public interface ProjectService extends Service{
	void create(Project project, DeferredResponse deferredResponse);
	Project get(int id);
	List<Project> get(User user);
	void update(Project project);
	void delete(Project project);
}
