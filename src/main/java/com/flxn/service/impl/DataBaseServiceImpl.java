package com.flxn.service.impl;

import com.flxn.address.Address;
import com.flxn.fake.database.FakeDB;
import com.flxn.message.system.MessageSystem;
import com.flxn.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class DataBaseServiceImpl implements Service,Runnable {

	private Address address;
	private MessageSystem messageSystem;

	@Autowired
	private FakeDB fakeDB;

	public FakeDB getFakeDB(){
		return fakeDB;
	}

	public DataBaseServiceImpl(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		this.address = new Address();
		this.messageSystem.registerService(getAddress());
	}

	@Override
	public void run() {
		long startRound;
		long endRound;
		while (true){
			startRound = System.nanoTime();
			messageSystem.execMessage(this);
			endRound = System.nanoTime();
			try {
				Thread.sleep(100-((endRound-startRound)/1000000));
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