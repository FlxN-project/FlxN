package com.flxn.message.system;

import com.flxn.address.Address;
import com.flxn.message.api.Msg;
import com.flxn.service.api.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class MessageSystem {

	private final Map<Address,ConcurrentLinkedQueue<Msg>> messages = new HashMap<Address, ConcurrentLinkedQueue<Msg>>();

	public void sendMessage(Msg message){
		Queue<Msg> serviceQueue = messages.get(message.getTo());
		serviceQueue.add(message);
	}

	public void execMessage(Service service){
		Queue<Msg> serviceQueue = messages.get(service.getAddress());
		while(!serviceQueue.isEmpty()){
			Msg message = serviceQueue.poll();
			message.exec(service);
		}
	}
}
