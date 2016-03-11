package com.flxn.message.impl;

import com.flxn.address.Address;
import com.flxn.message.api.MsgToAccount;
import com.flxn.service.impl.AccountService;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class MsgToAccountAuthUserImpl extends MsgToAccount {

	public MsgToAccountAuthUserImpl(Address to, Address from) {
		super(to, from);
	}

	@Override
	public void exec(AccountService accountService) {

	}
}
