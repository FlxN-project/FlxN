package com.flxn.security;

import com.flxn.fake.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Gadzzzz on 25.03.2016.
 */
public class AuthFilter implements Filter {

	private final TokenAuthenticationService authenticationService;
	private final String[] paths;

	public AuthFilter(TokenAuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
		this.paths = new String[]{
			"/resource/auth",
			"/resource/register",
			"/resource/error"};
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestPath = httpRequest.getRequestURI();
		System.out.println("FROM AUTH FILTER");
		if(!availablePath(requestPath)) {
			User user = authenticationService.getAuthentication(httpRequest);
			if (user != null)
				request.setAttribute("auth", user);
			else {
				httpRequest.getRequestDispatcher("/resource/error?stcode=403").forward(request, response);
				return;
			}
		}
		filterChain.doFilter(httpRequest, response);
	}

	@Override
	public void destroy() {

	}

	private boolean availablePath(String pathToCheck){
		boolean available = false;
		for (String path:paths)
			if(path.equals(pathToCheck)){
				available = true;
				break;
			}
		return available;
	}
}
