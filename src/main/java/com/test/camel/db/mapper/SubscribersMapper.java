package com.test.camel.db.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.camel.db.entity.SubscribersE;

public class SubscribersMapper {
	public Map<String, Object> getMap(SubscribersE sub) {
        Map<String, Object> record = new HashMap<String, Object>();
        record.put("Id", sub.getId());
        record.put("name", sub.getName());
        record.put("age", sub.getAge());
        record.put("msisdn", sub.getMsisdn());
        record.put("age_discount", sub.getAge_discount());
        return record;
    }
	
	public List<SubscribersE> getSubscribersE(List<Map<String, String>> dataList) {

        System.out.println("data:" + dataList);

        List<SubscribersE> subs = new ArrayList<SubscribersE>();

        for (Map<String, String> data : dataList) {

        	SubscribersE sub = new SubscribersE();

            sub.setId(Integer.parseInt(data.get("Id")));
            sub.setName(data.get("name"));
            sub.setAge(Integer.parseInt(data.get("age")));
            sub.setMsisdn(data.get("msisdn"));
            sub.setAge_discount(data.get("age_discount"));
            subs.add(sub);
        }
        return subs;
    }
}
