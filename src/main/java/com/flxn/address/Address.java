package com.flxn.address;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Gadzzzz on 11.03.2016.
 */
public class Address {
	static private AtomicInteger servicetIdCreator = new AtomicInteger();
	private int abonentId;

	public Address() {
		this.abonentId = servicetIdCreator.incrementAndGet();
	}

	@Override
	public int hashCode() {
		return abonentId;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Address) {
			Address address = (Address) obj;
			if(hashCode()==address.hashCode())
				return true;
		}
		return false;
	}
}
