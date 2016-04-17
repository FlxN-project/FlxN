package com.flxn.service.api;

import com.flxn.dao.model.Project;
import com.flxn.dao.model.User;
import com.flxn.service.logic.DeferredResponse;

import java.util.List;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
public interface BasicService<T> extends Service{
	void create(T model, DeferredResponse deferredResponse);
	void get(int id, DeferredResponse deferredResponse);
	void get(User user, DeferredResponse deferredResponse);
	void update(T model, DeferredResponse deferredResponse);
	void delete(T model, DeferredResponse deferredResponse);
}
