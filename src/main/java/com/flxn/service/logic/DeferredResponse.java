package com.flxn.service.logic;

import java.util.Map;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
public class DeferredResponse<T> {

	private volatile boolean isDone = false;
	private Exception exception;
	private T data;

	public synchronized void defer(){
		while (!isDone)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	public Exception getException() {
		return exception;
	}

	public T getData(){
		return data;
	}

	public void setData(T data,Exception exception){
		this.data = data;
		this.exception = exception;
	}

	public synchronized void done(){
		this.isDone = true;
		notify();
	}

}
