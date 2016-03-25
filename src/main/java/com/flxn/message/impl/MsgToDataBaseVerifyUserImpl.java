package com.flxn.message.impl;

import com.flxn.address.Address;
import com.flxn.fake.model.User;
import com.flxn.message.api.Msg;
import com.flxn.message.api.MsgToDataBase;
import com.flxn.service.impl.DataBaseServiceImpl;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class MsgToDataBaseVerifyUserImpl extends MsgToDataBase {

	private String email;

	public MsgToDataBaseVerifyUserImpl(Address to, Address from, String email) {
		super(to, from);
		this.email = email;
	}

	@Override
	public void exec(DataBaseServiceImpl dataBaseService) {
		User user = dataBaseService.getFakeDB().getUser(email);
		Msg back = new MsgToUserServiceImpl(getFrom(),getTo(), user, email);
		dataBaseService.getMessageSystem().sendMessage(back);
	}
}
