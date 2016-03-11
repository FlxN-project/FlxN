package com.flxn.message.api;

import com.flxn.address.Address;
import com.flxn.service.api.Service;
import com.flxn.service.impl.FrontEndServiceImpl;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public abstract class MsgToFrontEnd extends Msg {


	public MsgToFrontEnd(Address to, Address from) {
		super(to, from);
	}

	@Override
	public void exec(Service service) {
		if(service instanceof FrontEndServiceImpl)
			exec((FrontEndServiceImpl) service);
		else
			throw new RuntimeException("Wrong service");
	}

	public abstract void exec(FrontEndServiceImpl frontEndService);
}
