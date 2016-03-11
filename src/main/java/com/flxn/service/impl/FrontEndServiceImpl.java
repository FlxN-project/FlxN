package com.flxn.service.impl;

import com.flxn.address.Address;
import com.flxn.message.system.MessageSystem;
import com.flxn.service.api.Service;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class FrontEndServiceImpl implements Service,Runnable {

	private Address address;
	private MessageSystem messageSystem;

	public FrontEndServiceImpl(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		this.address = new Address();
		this.messageSystem.registerService(getAddress());
	}

	@Override
	public void run() {
		while (true){
			messageSystem.execMessage(this);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
