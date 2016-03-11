package com.flxn.message.api;

import com.flxn.address.Address;
import com.flxn.service.api.Service;
import com.flxn.service.impl.DataBaseService;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public abstract class MsgToDataBase extends Msg {


	public MsgToDataBase(Address to, Address from) {
		super(to, from);
	}

	@Override
	public void exec(Service service) {
		if(service instanceof DataBaseService)
			exec((DataBaseService)service);
		else
			throw new RuntimeException("Wrong service");
	}

	public abstract void exec(DataBaseService dataBaseService);
}
