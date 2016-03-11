package com.flxn.service.api;

import com.flxn.model.User;

import javax.servlet.http.HttpSession;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public interface AccountService extends Service {
	void logIn(User user, HttpSession session);
	void logOut(HttpSession session);
	void register(User user);
	User getUser(HttpSession session);
	boolean isRegistered(String email);
	boolean isAuthorized(HttpSession session);
}
