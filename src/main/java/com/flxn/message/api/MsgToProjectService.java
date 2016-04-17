package com.flxn.message.api;

import com.flxn.address.Address;
import com.flxn.service.api.Service;
import com.flxn.service.impl.ProjectServiceImpl;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
public abstract class MsgToProjectService extends Msg {

	protected DeferredResponse deferredResponse;

	public MsgToProjectService(Address to, Address from, DeferredResponse deferredResponse) {
		super(to, from);
		this.deferredResponse = deferredResponse;
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
