package com.flxn.service.api;


import com.flxn.dao.model.User;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 28.03.2016.
 */
public interface UserService extends Service{
	void loadUserByEmail(String email);
	void auth(String email,User user);
	boolean existUser(String email);
	User getAuth(String email);
	void register(User user, DeferredResponse<User> deferredResponse);
	void updateUser(User user, DeferredResponse<User> deferredResponse);
}
