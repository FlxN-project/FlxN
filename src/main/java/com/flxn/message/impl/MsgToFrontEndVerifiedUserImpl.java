package com.flxn.message.impl;

import com.flxn.address.Address;
import com.flxn.fake.model.User;
import com.flxn.message.api.MsgToFrontEnd;
import com.flxn.security.api.Finishable;
import com.flxn.service.impl.FrontEndServiceImpl;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class MsgToFrontEndVerifiedUserImpl extends MsgToFrontEnd {

	private User user;
	private Finishable<User> finishable;

	public MsgToFrontEndVerifiedUserImpl(Address to, Address from, User user, Finishable<User> finishable) {
		super(to, from);
		this.user = user;
		this.finishable = finishable;
	}

	@Override
	public void exec(FrontEndServiceImpl frontEndService) {
		finishable.setContent(user);
		finishable.finish();
	}
}
