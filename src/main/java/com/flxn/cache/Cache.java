package com.flxn.cache;

import com.flxn.dao.model.FlexObjject;
import com.google.common.cache.CacheBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Gadzzzz on 28.03.2016.
 */
public class Cache{

	private int CACHE_SIZE = 1_000_000;

	private final com.google.common.cache.Cache<Integer,ResponseEntity<Map<Integer,FlexObjject>>> cache;

	public Cache() {
		cache = CacheBuilder
			.newBuilder()
			.softValues()
			.maximumSize(CACHE_SIZE)
			.build();
	}

	public boolean exist(int project){
		return cache.getIfPresent(project)!=null?true:false;
	}

	public boolean exist(int project,int object){
		return cache.getIfPresent(project).getBody().get(object)!=null?true:false;
	}

	public boolean exist(int project,int start,int limit){
		for(int i=start;i<start+limit;i++)
			if(!exist(project,i))
				return false;
		return true;
	}

	public ResponseEntity<Map<Integer,FlexObjject>> getOne(int project, int object){
		Map<Integer,FlexObjject> resp = new HashMap<>();
		resp.put(object,cache.getIfPresent(project).getBody().get(object));
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}

	public ResponseEntity<Map<Integer,FlexObjject>> getAll(int project){
		return cache.getIfPresent(project);
	}

	public ResponseEntity<Map<Integer,FlexObjject>> getRange(int project,int start,int limit){
		Map<Integer,FlexObjject> resp = new HashMap<>();
		for(int i=start;i<start+limit;i++)
			resp.put(i,cache.getIfPresent(project).getBody().get(i));
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}

	public void add(int project,ResponseEntity<Map<Integer,FlexObjject>> resp){
		cache.put(project,resp);
	}
}
