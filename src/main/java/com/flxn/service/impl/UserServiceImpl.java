package com.flxn.service.impl;

import com.flxn.address.Address;
import com.flxn.dao.api.UserDao;
import com.flxn.dao.model.User;
import com.flxn.message.api.Msg;
import com.flxn.message.impl.MsgToDataBaseGetUserImpl;
import com.flxn.message.impl.MsgToDataBaseRegisterUserImpl;
import com.flxn.message.system.MessageSystem;
import com.flxn.service.api.UserService;
import com.flxn.service.logic.DeferredResponse;
import com.flxn.service.logic.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gadzzzz on 15.03.2016.
 */
public class UserServiceImpl implements UserService,Runnable{

	@Autowired
	@Qualifier("userDAO")
	private UserDao userDao;

	private final Address address;
	private final MessageSystem messageSystem;
	private final Runner runner;

	private final Map<String, User> users;

	public UserServiceImpl(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		this.address = new Address();
		this.messageSystem.registerService(UserServiceImpl.class,getAddress());
		this.users = Collections.synchronizedMap(new HashMap());
		this.runner = new Runner(this);
	}

	public void loadUserByEmail(String email) {
		Msg getUser = new MsgToDataBaseGetUserImpl(
			messageSystem.getService(DataBaseServiceImpl.class),
			getAddress(),
			email,
			userDao);
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
	public void register(User user, DeferredResponse deferredResponse) {
		Msg registerUser = new MsgToDataBaseRegisterUserImpl(
			messageSystem.getService(DataBaseServiceImpl.class),
			getAddress(),
			user,
			userDao,
			deferredResponse);
		messageSystem.sendMessage(registerUser);
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