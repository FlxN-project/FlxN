package com.flxn.message.api;

import com.flxn.address.Address;
import com.flxn.service.api.Service;
import com.flxn.service.impl.ProjectServiceImpl;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
public abstract class MsgToProjectService extends Msg {

	public MsgToProjectService(Address to, Address from) {
		super(to, from);
	}

	@Override
	public void exec(Service service) {
		if(service instanceof ProjectServiceImpl)
			exec((ProjectServiceImpl)service);
		else
			throw new RuntimeException("Wrong service");
	}

	public abstract void exec(ProjectServiceImpl userService);
}
