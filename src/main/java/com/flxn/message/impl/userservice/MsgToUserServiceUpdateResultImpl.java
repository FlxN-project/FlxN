package com.flxn.message.impl.userservice;

import com.flxn.address.Address;
import com.flxn.message.api.MsgToUserService;
import com.flxn.service.impl.UserServiceImpl;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
public class MsgToUserServiceUpdateResultImpl extends MsgToUserService {

	private DeferredResponse deferredResponse;

	public MsgToUserServiceUpdateResultImpl(Address to, Address from, DeferredResponse deferredResponse) {
		super(to, from);
		this.deferredResponse = deferredResponse;
	}

	@Override
	public void exec(UserServiceImpl userService) {
		deferredResponse.done();
	}
}
