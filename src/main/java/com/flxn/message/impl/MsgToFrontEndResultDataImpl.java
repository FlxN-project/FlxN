package com.flxn.message.impl;

import com.flxn.address.Address;
import com.flxn.message.api.MsgToFrontEnd;
import com.flxn.service.impl.FrontEndServiceImpl;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class MsgToFrontEndResultDataImpl extends MsgToFrontEnd {

	public MsgToFrontEndResultDataImpl(Address to, Address from) {
		super(to, from);
	}

	@Override
	public void exec(FrontEndServiceImpl frontEndService) {

	}
}
