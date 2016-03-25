package com.flxn.message.api;

import com.flxn.address.Address;
import com.flxn.service.api.Service;
import com.flxn.service.impl.UserServiceImpl;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public abstract class MsgToUserService extends Msg {


	public MsgToUserService(Address to, Address from) {
		super(to, from);
	}

	@Override
	public void exec(Service service) {
		if(service instanceof UserServiceImpl)
			exec((UserServiceImpl) service);
		else
			throw new RuntimeException("Wrong service");
	}

	public abstract void exec(UserServiceImpl userService);
}
