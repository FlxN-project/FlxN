package com.flxn.message.impl.database;

import com.flxn.address.Address;
import com.flxn.dao.api.UserDao;
import com.flxn.dao.model.User;
import com.flxn.message.api.Msg;
import com.flxn.message.api.MsgToDataBase;
import com.flxn.message.api.MsgToDataBaseWithDefer;
import com.flxn.message.impl.userservice.MsgToUserServiceRegisterResultImpl;
import com.flxn.service.impl.DataBaseServiceImpl;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 14.04.2016.
 */
public class MsgToDataBaseRegisterUserImpl extends MsgToDataBaseWithDefer {

	private User user;
	private UserDao userDao;

	public MsgToDataBaseRegisterUserImpl(Address to, Address from, User user, UserDao userDao,DeferredResponse deferredResponse) {
		super(to, from, deferredResponse);
		this.user = user;
		this.userDao = userDao;
	}

	@Override
	public void exec(DataBaseServiceImpl dataBaseService) {
		Msg back;
		try {
			userDao.create(user);
			deferredResponse.setData(null,null);
			back = new MsgToUserServiceRegisterResultImpl(getFrom(),getTo(),deferredResponse);
		}catch (UnsupportedOperationException e){
			deferredResponse.setData(null,e);
			back = new MsgToUserServiceRegisterResultImpl(getFrom(),getTo(),deferredResponse);
		}
		dataBaseService.getMessageSystem().sendMessage(back);
	}
}
