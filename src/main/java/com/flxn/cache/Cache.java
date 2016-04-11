package com.flxn.cache;

import com.flxn.dao.model.FlexObjject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Gadzzzz on 28.03.2016.
 */
public class Cache{

	private final Map<Integer,ResponseEntity<Map<Integer,FlexObjject>>> cache;

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

	public ResponseEntity<Map<Integer,FlexObjject>> getOne(int project, int object){//Wrong realizetion list index != database id
		Map<Integer,FlexObjject> resp = new HashMap<>();
		resp.put(object,cache.get(project).getBody().get(object));
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}

	public ResponseEntity<Map<Integer,FlexObjject>> getAll(int project){
		return cache.get(project);
	}

	public void add(int project,ResponseEntity<Map<Integer,FlexObjject>> resp){
		cache.put(project,resp);
	}
}
