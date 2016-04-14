package com.flxn.service.impl;

import com.flxn.address.Address;
import com.flxn.message.system.MessageSystem;
import com.flxn.service.api.DataBaseService;
import com.flxn.service.logic.Runner;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class DataBaseServiceImpl implements DataBaseService,Runnable {

	private final Address address;
	private final MessageSystem messageSystem;
	private final Runner runner;

	public DataBaseServiceImpl(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		this.address = new Address();
		this.messageSystem.registerService(DataBaseServiceImpl.class,getAddress());
		this.runner = new Runner(this);
	}

	@Override
	public void run() {
		runner.runner();
	}

	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public MessageSystem getMessageSystem() {
		return messageSystem;
	}
}
