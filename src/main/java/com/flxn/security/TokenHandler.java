package com.flxn.security;
import com.flxn.dao.model.User;
import com.flxn.service.impl.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Created by Gadzzzz on 15.03.2016.
 */
public final class TokenHandler {

	private final String secret;
	private UserServiceImpl userService;

	public TokenHandler(String secret,UserServiceImpl userService) {
		this.secret = secret;
		this.userService = userService;
	}

	public User parseUserFromToken(String token) {
		String email = Jwts.parser()
			.setSigningKey(secret)
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
		return userService.getAuth(email);
	}

	public String createTokenForUser(User user) {
		return Jwts.builder()
			.setSubject(user.getEmail())
			.signWith(SignatureAlgorithm.HS512, secret)
			.compact();
	}
}