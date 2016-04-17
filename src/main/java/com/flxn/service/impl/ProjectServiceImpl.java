package com.flxn.service.impl;

import com.flxn.address.Address;
import com.flxn.dao.api.ProjectDao;
import com.flxn.dao.model.Project;
import com.flxn.dao.model.User;
import com.flxn.message.impl.database.MsgToDataBaseCreateProjectImpl;
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
			deferredResponse
		);
		messageSystem.sendMessage(createProject);
	}

	@Override
	public Project get(int id) {
		return null;
	}

	@Override
	public List<Project> get(User user) {
		return null;
	}

	@Override
	public void update(Project project) {

	}

	@Override
	public void delete(Project project) {

	}
}
