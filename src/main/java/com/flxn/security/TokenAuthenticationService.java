package com.flxn.security;

import com.flxn.fake.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gadzzzz on 15.03.2016.
 */
public class TokenAuthenticationService {

	private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";

	@Autowired
	private TokenHandler tokenHandler;

	public void addAuthentication(HttpServletResponse response, User authUser) {
		final User user = authUser;
		String token = tokenHandler.createTokenForUser(user);
		response.addHeader(AUTH_HEADER_NAME, token);
	}

	public User getAuthentication(HttpServletRequest request) {
		final String token = request.getHeader(AUTH_HEADER_NAME);
		if (token != null) {
			final User user = tokenHandler.parseUserFromToken(token);
			if (user != null) {
				return user;
			}
		}
		return null;
	}
}
