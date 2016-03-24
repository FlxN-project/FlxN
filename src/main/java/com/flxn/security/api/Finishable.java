package com.flxn.security.api;

/**
 * Created by Gadzzzz on 24.03.2016.
 */
public interface Finishable<T> {
	void finish();
	void setContent(T obj);
}
