package com.flxn.cache;

import com.flxn.cache.Cache;
import com.flxn.cache.check.api.ExistInCache;
import com.flxn.cache.check.impl.ExistAll;
import com.flxn.cache.check.impl.ExistOne;
import com.flxn.cache.check.impl.ExistRange;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gadzzzz on 29.03.2016.
 */
public class CacheFilter implements Filter {
	private Cache cache;
	private final Map<String,ExistInCache> cacheDo;

	public CacheFilter(Cache cache) {
		this.cache = cache;
		this.cacheDo = new HashMap<>();
		this.cacheDo.put("/resource/getall",new ExistAll());
		this.cacheDo.put("/resource/getone",new ExistOne());
		this.cacheDo.put("/resource/getrange",new ExistRange());
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
				String path = httpRequest.getRequestURI();
				ExistInCache existInCache = cacheDo.get(path);
				if(existInCache!=null)
					if(existInCache.exist(request,cache))
						httpRequest.getRequestDispatcher(existInCache.getPath()).forward(request, response);
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
