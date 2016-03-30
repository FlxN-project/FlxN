package com.flxn.cache;

import com.flxn.fake.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Gadzzzz on 28.03.2016.
 */
public class Cache<T extends ResponseEntity<List<?>>> {

	private final Map<Integer,T> cache;

	public Cache() {
		cache = new ConcurrentHashMap<>();
	}

	public boolean exist(int project){
		return cache.containsKey(project);
	}

	public T getOne(int project, int object){
		List<Object> resp = new ArrayList<>();
		resp.add(cache.get(project).getBody().get(object));
		return (T) new ResponseEntity<List<?>>(resp,HttpStatus.OK);
	}

	public T getAll(int project){
		return cache.get(project);
	}

	public void add(int project,T resp){
		cache.put(project,resp);
	}
}
