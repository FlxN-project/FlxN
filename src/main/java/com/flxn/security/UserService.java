package com.flxn.security;

import com.flxn.fake.database.FakeDB;
import com.flxn.message.api.Msg;
import com.flxn.message.impl.MsgToDataBaseVerifyUserImpl;
import com.flxn.message.system.MessageSystem;
import com.flxn.security.api.Finishable;
import com.flxn.service.impl.DataBaseServiceImpl;
import com.flxn.service.impl.FrontEndServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Gadzzzz on 15.03.2016.
 */
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService,Finishable<com.flxn.fake.model.User> {

	@Autowired
	private FrontEndServiceImpl frontEndService;

	@Autowired
	private DataBaseServiceImpl dataBaseService;

	private volatile boolean running = true;

	private com.flxn.fake.model.User fromDB;

	private final AccountStatusUserDetailsChecker detailsChecker;

	public UserService() {
		detailsChecker = new AccountStatusUserDetailsChecker();
	}

	@Override
	public final User loadUserByUsername(String email) throws UsernameNotFoundException {
		Msg getUser = new MsgToDataBaseVerifyUserImpl(dataBaseService.getAddress(),frontEndService.getAddress(),email,this);
		frontEndService.getMessageSystem().sendMessage(getUser);
//		com.flxn.fake.model.User fromDb = fakeDB.getUser(email);
		while (running){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		GrantedAuthority authority = new SimpleGrantedAuthority(fromDB.getRole());
		final User user = new User(fromDB.getEmail(), fromDB.getPassword(), Arrays.asList(authority));
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		detailsChecker.check(user);
		return user;
	}

	@Override
	public void finish() {
		running = false;
	}

	@Override
	public void setContent(com.flxn.fake.model.User obj) {
		fromDB = obj;
	}
}