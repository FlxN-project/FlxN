package com.flxn.service.logic;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
public class DeferredResponse {

	private volatile boolean isDone = false;
	private Exception exception;

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

	public synchronized void done(Exception exception){
		this.exception = exception;
		this.isDone = true;
		notify();
	}

}
