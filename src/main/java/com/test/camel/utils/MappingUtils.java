package com.test.camel.utils;

import com.test.camel.db.entity.SubscribersE;
import com.test.camel.domain.Subscribers;

public class MappingUtils {
public static SubscribersE maptoEntity(Subscribers domain) {
	SubscribersE entity = new SubscribersE();
	entity.setId(domain.getId());
	entity.setAge(domain.getAge());
	entity.setMsisdn(domain.getMsisdn());
	entity.setName(domain.getName());
	
	return entity;
}


public static Subscribers maptoDomain(SubscribersE entity) {
	Subscribers domain = new Subscribers();
	domain.setId(entity.getId());
	domain.setAge(entity.getAge());
	domain.setMsisdn(entity.getMsisdn());
	domain.setName(entity.getName());
	return domain;
}
}
