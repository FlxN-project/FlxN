package com.flxn.message.impl.projectservice;

import com.flxn.address.Address;
import com.flxn.message.api.MsgToProjectService;
import com.flxn.service.impl.ProjectServiceImpl;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
public class MsgToProjectServiceCreateResultImpl extends MsgToProjectService {

	private DeferredResponse deferredResponse;

	public MsgToProjectServiceCreateResultImpl(Address to, Address from, DeferredResponse deferredResponse) {
		super(to, from);
		this.deferredResponse = deferredResponse;
	}

	@Override
	public void exec(ProjectServiceImpl userService) {
		deferredResponse.done();
	}
}
