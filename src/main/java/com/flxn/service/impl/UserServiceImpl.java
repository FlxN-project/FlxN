package com.flxn.service.impl;

import com.flxn.address.Address;
import com.flxn.fake.model.User;
import com.flxn.message.api.Msg;
import com.flxn.message.impl.MsgToDataBaseVerifyUserImpl;
import com.flxn.message.system.MessageSystem;
import com.flxn.service.api.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gadzzzz on 15.03.2016.
 */
public class UserServiceImpl implements Service,Runnable{

	private Address address;
	private MessageSystem messageSystem;

	private final Map<String, User> users;

	public UserServiceImpl(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		this.address = new Address();
		this.messageSystem.registerService(UserServiceImpl.class,getAddress());
		this.users = Collections.synchronizedMap(new HashMap());
	}

	public void loadUserByUsername(String email) throws UsernameNotFoundException {
		Msg getUser = new MsgToDataBaseVerifyUserImpl(messageSystem.getService(DataBaseServiceImpl.class),getAddress(),email);
		messageSystem.sendMessage(getUser);
	}

	public void auth(String email,User user){
		users.put(email,user);
	}

	public boolean existUser(String email){
		return users.containsKey(email);
	}

	public User getAuth(String email){
		return users.get(email);
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