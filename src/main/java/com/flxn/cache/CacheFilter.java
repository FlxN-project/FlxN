package com.flxn.cache;

import com.flxn.cache.Cache;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Gadzzzz on 29.03.2016.
 */
public class CacheFilter implements Filter {
	private Cache cache;

	public CacheFilter(Cache cache) {
		this.cache = cache;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String method = httpRequest.getMethod();
		if(method.equals("GET")){
			try {
				int project = Integer.parseInt(request.getParameter("project"));
				if (cache.exist(project)) {
					httpRequest.getRequestDispatcher("/resource/returncachedall").forward(request, response);
					System.out.println("FROM CACHE FILTER");
					return;
				}
			}catch (NumberFormatException e){
				httpRequest.getRequestDispatcher("/resource/error").forward(request, response);
				return;
			};
		}
		filterChain.doFilter(request,response);
	}

	@Override
	public void destroy() {

	}
}
