package com.flxn.message.impl;

import com.flxn.address.Address;
import com.flxn.dao.api.UserDao;
import com.flxn.dao.model.User;
import com.flxn.message.api.MsgToDataBase;
import com.flxn.service.impl.DataBaseServiceImpl;

/**
 * Created by Gadzzzz on 14.04.2016.
 */
public class MsgToDataBaseRegisterUserImpl extends MsgToDataBase {

	private User user;
	private UserDao userDao;

	public MsgToDataBaseRegisterUserImpl(Address to, Address from, User user, UserDao userDao) {
		super(to, from);
		this.user = user;
		this.userDao = userDao;
	}

	@Override
	public void exec(DataBaseServiceImpl dataBaseService) {
		userDao.create(user);
	}
}
