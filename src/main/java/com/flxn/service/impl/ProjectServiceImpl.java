package com.flxn.service.impl;

import com.flxn.address.Address;
import com.flxn.dao.api.ProjectDao;
import com.flxn.dao.model.Project;
import com.flxn.dao.model.User;
import com.flxn.message.impl.database.*;
import com.flxn.message.system.MessageSystem;
import com.flxn.service.api.BasicService;
import com.flxn.service.logic.DeferredResponse;
import com.flxn.service.logic.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
public class ProjectServiceImpl implements BasicService<Project>,Runnable{

	@Autowired
	@Qualifier("projectDAO")
	private ProjectDao projectDao;

	private final Address address;
	private final MessageSystem messageSystem;
	private final Runner runner;

	public ProjectServiceImpl(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		this.address = new Address();
		this.messageSystem.registerService(ProjectServiceImpl.class,getAddress());
		this.runner = new Runner(this);
	}

	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public MessageSystem getMessageSystem() {
		return messageSystem;
	}

	@Override
	public void run() {
		runner.runner();
	}

	@Override
	public void create(Project project, DeferredResponse deferredResponse) {
		MsgToDataBaseCreateProjectImpl createProject = new MsgToDataBaseCreateProjectImpl(
			messageSystem.getService(DataBaseServiceImpl.class),
			getAddress(),
			project,
			projectDao,
			deferredResponse,
			project.getParent().getId(),
			project.getParent().getId()
		);
		messageSystem.sendMessage(createProject);
	}

	@Override
	public void get(int id, DeferredResponse deferredResponse,int userid) {
		MsgToDataBaseGetProjectImpl getProject = new MsgToDataBaseGetProjectImpl(
			messageSystem.getService(DataBaseServiceImpl.class),
			getAddress(),
			deferredResponse,
			id,
			projectDao,
			userid
		);
		messageSystem.sendMessage(getProject);
	}

	@Override
	public void get(User user, DeferredResponse deferredResponse) {
		MsgToDataBaseGetAllProjectsImpl getAllProjects = new MsgToDataBaseGetAllProjectsImpl(
			messageSystem.getService(DataBaseServiceImpl.class),
			getAddress(),
			deferredResponse,
			user,
			projectDao,
			user.getId()
		);
		messageSystem.sendMessage(getAllProjects);
	}

	@Override
	public void update(Project project, DeferredResponse deferredResponse) {
		MsgToDataBaseUpdateProjectImpl updateProject = new MsgToDataBaseUpdateProjectImpl(
			messageSystem.getService(DataBaseServiceImpl.class),
			getAddress(),
			deferredResponse,
			project,
			projectDao,
			project.getParent().getId()
		);
		messageSystem.sendMessage(updateProject);
	}

	@Override
	public void delete(Project project, DeferredResponse deferredResponse) {
		MsgToDataBaseDeleteProjectImpl deleteProject = new MsgToDataBaseDeleteProjectImpl(
			messageSystem.getService(DataBaseServiceImpl.class),
			getAddress(),
			deferredResponse,
			project,
			projectDao,
			project.getParent().getId()
		);
		messageSystem.sendMessage(deleteProject);
	}
}
