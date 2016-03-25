package com.flxn.resource;

import com.flxn.fake.model.User;
import com.flxn.security.TokenAuthenticationService;
import com.flxn.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
@RestController
public class Auth {

	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/auth",method = RequestMethod.POST)
	public ResponseEntity<?> token(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		userService.loadUserByUsername(email);
		boolean waiting = true;
		User user = null;
		while(waiting){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(userService.existUser(email)) {
				user = userService.getAuth(email);
				if (user != null)
					waiting = false;
				else {
					ResponseEntity responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
					return responseEntity;
				}
			}
		}
		if(!user.getPassword().equals(password)){
			ResponseEntity responseEntity = new ResponseEntity(HttpStatus.UNAUTHORIZED);
			return responseEntity;
		}
		tokenAuthenticationService.addAuthentication(response, user);
		ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/welcome",method = RequestMethod.POST)
	public ResponseEntity<?> check(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = (User) request.getAttribute("auth");
		ResponseEntity responseEntity = new ResponseEntity(user,HttpStatus.OK);
		return responseEntity;
	}
}