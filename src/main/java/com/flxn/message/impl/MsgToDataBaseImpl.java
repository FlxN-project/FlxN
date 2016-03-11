package com.flxn.message.impl;

import com.flxn.address.Address;
import com.flxn.message.api.MsgToDataBase;
import com.flxn.service.impl.DataBaseService;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class MsgToDataBaseImpl extends MsgToDataBase {

	public MsgToDataBaseImpl(Address to, Address from) {
		super(to, from);
	}

	@Override
	public void exec(DataBaseService dataBaseService) {

	}
}
