package com.flxn.resource;

import com.flxn.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gadzzzz on 29.03.2016.
 */
@RestController
public class ChooseCache {

	@Autowired
	private Cache cache;

	@RequestMapping(value = "/returncachedrange", method = RequestMethod.GET)
	private ResponseEntity returnCachedRange(HttpServletRequest request){
		int project = Integer.parseInt(request.getParameter("project"));
		int start = Integer.parseInt(request.getParameter("start"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		return null;
	}

	@RequestMapping(value = "/returncachedone", method = RequestMethod.GET)
	private ResponseEntity returnCachedOne(HttpServletRequest request){
		int project = Integer.parseInt(request.getParameter("project"));
		int object = Integer.parseInt(request.getParameter("object"));
		return null;
	}

	@RequestMapping(value = "/returncachedall", method = RequestMethod.GET)
	public ResponseEntity returnCachedAll(HttpServletRequest request){
		int project = Integer.parseInt(request.getParameter("project"));
		return cache.getAll(project);
	}
}
