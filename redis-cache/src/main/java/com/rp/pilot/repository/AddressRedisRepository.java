package com.rp.pilot.repository;

import com.rp.pilot.model.Address;

public interface AddressRedisRepository {
	public void add(String nid, String hash, Address address);

}
