package com.flxn.cache.check.impl;

import com.flxn.cache.Cache;
import com.flxn.cache.check.api.ExistInCache;

import javax.servlet.ServletRequest;

/**
 * Created by Gadzzzz on 31.03.2016.
 */
public class ExistRange implements ExistInCache {

	@Override
	public boolean exist(ServletRequest request , Cache cache) throws NumberFormatException {
		int project = Integer.parseInt(request.getParameter("project"));
		int start = Integer.parseInt(request.getParameter("start"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		if (cache.exist(project,start,limit))
			return true;
		return false;
	}
}