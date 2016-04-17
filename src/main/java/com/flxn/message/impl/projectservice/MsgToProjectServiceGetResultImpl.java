package com.flxn.message.impl.projectservice;

import com.flxn.address.Address;
import com.flxn.message.api.MsgToProjectService;
import com.flxn.service.impl.ProjectServiceImpl;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 17.04.2016.
 */
public class MsgToProjectServiceGetResultImpl extends MsgToProjectService {
	public MsgToProjectServiceGetResultImpl(Address to, Address from, DeferredResponse deferredResponse) {
		super(to, from, deferredResponse);
	}

	@Override
	public void exec(ProjectServiceImpl userService) {
		deferredResponse.done();
	}
}
