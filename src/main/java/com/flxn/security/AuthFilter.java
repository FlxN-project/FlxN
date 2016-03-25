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

	public AuthFilter(TokenAuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestPath = httpRequest.getRequestURI();
		if(!requestPath.equals("/resource/auth")) {
			User user = authenticationService.getAuthentication(httpRequest);
			if (user != null) {
				request.setAttribute("auth", user);
				filterChain.doFilter(request, response);
			}else
				httpResponse.setStatus(403);
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
