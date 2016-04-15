package com.flxn.message.impl;

import com.flxn.address.Address;
import com.flxn.dao.api.UserDao;
import com.flxn.dao.model.User;
import com.flxn.message.api.Msg;
import com.flxn.message.api.MsgToDataBase;
import com.flxn.service.impl.DataBaseServiceImpl;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 14.04.2016.
 */
public class MsgToDataBaseRegisterUserImpl extends MsgToDataBase {

	private User user;
	private UserDao userDao;
	private DeferredResponse deferredResponse;

	public MsgToDataBaseRegisterUserImpl(Address to, Address from, User user, UserDao userDao,DeferredResponse deferredResponse) {
		super(to, from);
		this.user = user;
		this.userDao = userDao;
		this.deferredResponse = deferredResponse;
	}

	@Override
	public void exec(DataBaseServiceImpl dataBaseService) {
		Msg back;
		try {
			userDao.create(user);
			back = new MsgToUserServiceRegisterResultImpl(getFrom(),getTo(),null,deferredResponse);
		}catch (UnsupportedOperationException e){
			back = new MsgToUserServiceRegisterResultImpl(getFrom(),getTo(),e,deferredResponse);
		}
		dataBaseService.getMessageSystem().sendMessage(back);
	}
}
