package com.flxn.message.impl.database;

import com.flxn.address.Address;
import com.flxn.dao.api.UserDao;
import com.flxn.dao.model.User;
import com.flxn.message.api.Msg;
import com.flxn.message.api.MsgToDataBase;
import com.flxn.message.impl.userservice.MsgToUserServiceAuthUserImpl;
import com.flxn.service.impl.DataBaseServiceImpl;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class MsgToDataBaseGetUserImpl extends MsgToDataBase {

	private String email;
	private UserDao userDao;

	public MsgToDataBaseGetUserImpl(Address to, Address from, String email, UserDao userDao) {
		super(to, from);
		this.email = email;
		this.userDao = userDao;
	}

	@Override
	public void exec(DataBaseServiceImpl dataBaseService) {
		User user = userDao.getByEmail(email);
		Msg back = new MsgToUserServiceAuthUserImpl(getFrom(),getTo(), user, email);
		dataBaseService.getMessageSystem().sendMessage(back);
	}
}
