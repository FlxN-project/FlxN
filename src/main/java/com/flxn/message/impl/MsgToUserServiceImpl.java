package com.flxn.message.impl;

import com.flxn.address.Address;
import com.flxn.fake.model.User;
import com.flxn.message.api.MsgToUserService;
import com.flxn.service.impl.UserServiceImpl;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class MsgToUserServiceImpl extends MsgToUserService {

	private User fromDB;
	private String email;

	public MsgToUserServiceImpl(Address to, Address from, User user,String email) {
		super(to, from);
		this.fromDB = user;
		this.email = email;
	}

	@Override
	public void exec(UserServiceImpl userService) {
		if(fromDB!=null)
			userService.auth(email,fromDB);
		else
			userService.auth(email,null);
	}
}
