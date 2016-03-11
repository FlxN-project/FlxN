package com.flxn.service.impl;

import com.flxn.address.Address;
import com.flxn.message.system.MessageSystem;
import com.flxn.service.api.Service;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class FrontEndService implements Service,Runnable {

	private Address address;
	private MessageSystem messageSystem;

	public FrontEndService(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		this.address = new Address();
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
