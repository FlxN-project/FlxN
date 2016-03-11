package com.flxn.service.api;

import com.flxn.address.Address;
import com.flxn.message.system.MessageSystem;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public interface Service {
	public Address getAddress();
	public MessageSystem getMessageSystem();
}
