package com.flxn.message.api;

import com.flxn.address.Address;
import com.flxn.service.api.Service;
import com.flxn.service.impl.AccountService;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public abstract class MsgToAccount extends Msg {

	public MsgToAccount(Address to, Address from) {
		super(to, from);
	}

	@Override
	public void exec(Service service) {
		if(service instanceof AccountService)
			exec((AccountService) service);
		throw new RuntimeException("Wrong Service");
	}

	public abstract void exec(AccountService accountService);
}
