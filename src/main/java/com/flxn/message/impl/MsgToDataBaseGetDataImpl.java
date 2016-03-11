package com.flxn.message.impl;

import com.flxn.address.Address;
import com.flxn.message.api.MsgToDataBase;
import com.flxn.service.impl.DataBaseServiceImpl;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class MsgToDataBaseGetDataImpl extends MsgToDataBase {

	public MsgToDataBaseGetDataImpl(Address to, Address from) {
		super(to, from);
	}

	@Override
	public void exec(DataBaseServiceImpl dataBaseService) {

	}
}
