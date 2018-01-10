package com.rp.pilot.repository;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.rp.pilot.model.Address;

@Repository
public class AddressRedisRepositoryImpl implements AddressRedisRepository {
	@Resource(name = "redisTemplate")
	private HashOperations<String, String, Address> hashOperations;

	@Override
	public void add(String nid, String hash, Address address) {
		hashOperations.put(nid, hash, address);

	}

}
