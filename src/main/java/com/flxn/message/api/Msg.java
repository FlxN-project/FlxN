package com.flxn.message.api;

import com.flxn.address.Address;
import com.flxn.service.api.Service;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public abstract class Msg {

	private final Address to;
	private final Address from;

	public Msg(Address to, Address from) {
		this.to = to;
		this.from = from;
	}

	public Address getTo() {
		return to;
	}

	public Address getFrom() {
		return from;
	}

	public abstract void exec(Service service);
}
