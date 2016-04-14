package com.flxn.service.logic;

import com.flxn.service.api.Service;

/**
 * Created by Gadzzzz on 14.04.2016.
 */
public class Runner {
	private final Service service;

	public Runner(Service service) {
		this.service = service;
	}

	public void runner(){
		long startRound;
		long endRound;
		while (true){
			startRound = System.nanoTime();
			service.getMessageSystem().execMessage(service);
			endRound = System.nanoTime();
			try {
				Thread.sleep(sleepCount(startRound,endRound));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private long sleepCount(long startRound, long endRound) {
		long abs = Math.abs((endRound-startRound)/1000000);
		long sleep;
		if(abs>100)
			sleep = 100-(abs%100);
		else if(abs==0)
			sleep = 100;
		else
			sleep = 100 % abs;
		return sleep;
	}
}
