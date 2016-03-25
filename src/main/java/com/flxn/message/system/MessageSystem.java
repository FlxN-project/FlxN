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

	private final Map<Class<?>,Address> services;
	private final Map<Address,ConcurrentLinkedQueue<Msg>> messages;

	public MessageSystem() {
		this.messages = new HashMap<>();
		this.services = new HashMap<>();
	}

	public void registerService(Class<?> service,Address address){
		messages.put(address,new ConcurrentLinkedQueue<Msg>());
		services.put(service,address);
	}

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

	public Address getService(Class<?> service){
		return services.get(service);
	}
}
