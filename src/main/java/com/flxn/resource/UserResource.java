package com.flxn.resource;

import com.flxn.dao.api.UserDao;
import com.flxn.dao.model.User;
import com.flxn.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gadzzzz on 14.04.2016.
 */
@RestController
@RequestMapping(value = "user")
public class UserResource {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody User user){
		userService.register(user);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
