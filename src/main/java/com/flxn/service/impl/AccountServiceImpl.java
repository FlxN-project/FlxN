package com.flxn.service.impl;

import com.flxn.address.Address;
import com.flxn.message.system.MessageSystem;
import com.flxn.model.User;
import com.flxn.service.api.AccountService;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class AccountServiceImpl implements AccountService,Runnable{

	private Address address;
	private MessageSystem messageSystem;
	private Map<String,User> authUsers;

	public AccountServiceImpl(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		this.address = new Address();
		this.authUsers = new ConcurrentHashMap<String, User>();
		this.messageSystem.registerService(getAddress());
	}

	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public MessageSystem getMessageSystem() {
		return messageSystem;
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
	public void logIn(User user, HttpSession session) {

	}

	@Override
	public void logOut(HttpSession session) {

	}

	@Override
	public void register(User user) {

	}

	@Override
	public User getUser(HttpSession session) {
		return null;
	}

	@Override
	public boolean isRegistered(String email) {
		return false;
	}

	@Override
	public boolean isAuthorized(HttpSession session) {
		return false;
	}
}
