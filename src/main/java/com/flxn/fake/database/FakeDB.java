package com.flxn.fake.database;

import com.flxn.fake.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Gadzzzz on 24.03.2016.
 */
public class FakeDB {
	private Map<String,User> users;

	public FakeDB() {
		this.users = new ConcurrentHashMap<>();
		User user = User.getBuilder().build();
		System.out.println(user.getEmail()+";"+user.getPassword());
		users.put(user.getEmail(),user);
	}

	public User getUser(String email){
		return users.get(email);
	}

	public boolean exist(String email){
		return users.containsKey(email);
	}

	public void add(User user){
		users.put(user.getEmail(),user);
	}
}
