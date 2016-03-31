package com.flxn.cache;

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

	public boolean exist(int project,int object){
		Object cached = cache.get(project).getBody().get(object);
		if(cached!=null)
			return true;
		return false;
	}

	public boolean exist(int project,int start,int limit){
		for(int i=start;i<start+limit;i++)
			if(!exist(project,i))
				return false;
		return true;
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
