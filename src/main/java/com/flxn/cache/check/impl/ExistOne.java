package com.flxn.cache.check.impl;

import com.flxn.cache.Cache;
import com.flxn.cache.check.api.ExistInCache;

import javax.servlet.ServletRequest;

/**
 * Created by Gadzzzz on 31.03.2016.
 */
public class ExistOne implements ExistInCache {

	@Override
	public boolean exist(ServletRequest request, Cache cache) throws NumberFormatException {
		int project = Integer.parseInt(request.getParameter("project"));
		int object = Integer.parseInt(request.getParameter("object"));
		if (cache.exist(project,object))
			return true;
		return false;
	}
}