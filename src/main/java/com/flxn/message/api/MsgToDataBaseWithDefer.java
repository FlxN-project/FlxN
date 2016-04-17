package com.flxn.message.api;

import com.flxn.address.Address;
import com.flxn.service.impl.DataBaseServiceImpl;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 17.04.2016.
 */
public abstract class MsgToDataBaseWithDefer extends MsgToDataBase {

	protected DeferredResponse deferredResponse;

	public MsgToDataBaseWithDefer(Address to, Address from,DeferredResponse deferredResponse) {
		super(to, from);
		this.deferredResponse = deferredResponse;
	}

}
