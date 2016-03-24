package com.flxn.resource;

import com.flxn.security.TokenAuthenticationService;
import com.flxn.security.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
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
	@Qualifier("tokenAuthenticationService")
	private TokenAuthenticationService tokenAuthenticationService;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/auth",method = RequestMethod.POST)
	public ResponseEntity<?> token(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String login = request.getParameter("email");
		String password = request.getParameter("password");
		Authentication authentication = this.authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
				login,
				password
			)
		);
		User user = (User) authentication.getPrincipal();
		tokenAuthenticationService.addAuthentication(response, new UserAuthentication(user));
		ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
		return responseEntity;
	}
}