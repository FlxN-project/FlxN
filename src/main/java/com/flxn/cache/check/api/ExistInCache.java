package com.flxn.cache.check.api;

import com.flxn.cache.Cache;

import javax.servlet.ServletRequest;

/**
 * Created by Gadzzzz on 31.03.2016.
 */
public interface ExistInCache{
	boolean exist(ServletRequest request, Cache cache) throws NumberFormatException;
	String getPath();
}
