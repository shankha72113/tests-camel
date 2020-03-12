package com.test.camel.cache.service;

import org.springframework.stereotype.Controller;

import com.test.camel.cache.manager.CacheManager;
import com.test.camel.cache.objects.CachedObject;
import com.test.camel.domain.JsonResponse;
import com.test.camel.domain.Subscribers;
@Controller

public class CustomCacheService {
	
	public CustomCacheService() {
		Subscribers sub1=new Subscribers();
		sub1.setId(1);
		sub1.setName("S King");
		sub1.setAge(27);
		sub1.setMsisdn("99005552551122");
		int hcode = sub1.getId();
	
		 CachedObject co = new CachedObject(sub1, hcode, 5);
			System.out.println("Hashcode:"+hcode+"Cached Object identifier:"+co.getIdentifier()+":object is:"+co.getObject().toString());
		    /* Place the object into the cache! */
		    CacheManager.putCache(co);
		    Subscribers sub2=new Subscribers();
			sub2.setId(2);
			sub2.setName("A Lang");
			sub2.setAge(22);
			sub2.setMsisdn("99005552550022");
			int hcode2 = sub2.getId();
			
			 CachedObject co2 = new CachedObject(sub2, hcode2, 5);
			 System.out.println("Hashcode:"+hcode2+"Cached Object identifier:"+co2.getIdentifier()+":object is:"+co2.getObject().toString());
			    /* Place the object into the cache! */
			    CacheManager.putCache(co2);    
	}
	

	public Object getFromCache(Integer code) {
		System.out.println("Trying to get from cache with code::"+code);
		JsonResponse respJson = new JsonResponse();
		Subscribers sub = null;
		/* Try to retrieve the object from the cache! */
	    CachedObject o = (CachedObject)CacheManager.getCache(code);
	    
	    if(o==null) {
	    	System.out.println("Object in cache is null need to fetch from DB if possible");
	    }else {
	    	System.out.println("Received object from cache -- now extracting the actual subscriber");
	    	if(o.getObject() instanceof Subscribers)
	    			sub = (Subscribers) o.getObject();
	    	else
	    		System.out.println("the object in cached object is modified -- not a subscriber object");
	    	
	    }
	    if(sub!=null) {
	    	System.out.println("Subscriber extracted with name:"+sub.getName());
	    return sub;
	    }
	    else {
	    	System.out.println("Subscriber object not found!!");
	    	respJson.setMessage("Not found in cache");
	    	respJson.setStatusCode("404");
	    }
	    	return respJson;
	}

	public JsonResponse addToCache(Subscribers sub) {
		System.out.println("I am called in addToCache"+sub.toString());
		
		JsonResponse added = null;
		
		try {
			int code = sub.getId();
		/* Create an instance of CachedObject, set the minutesToLive to 1
		minute.  Give the
		       object some unique identifier.
		    */
		    CachedObject co = new CachedObject(sub, code, 5);
		    /* Place the object into the cache! */
		    CacheManager.putCache(co);
		    added = new JsonResponse();
		    added.setMessage("Added to Cache Successfully");
		    added.setStatusCode("200");
		}catch (Exception e) {
			System.out.println("Could not insert:"+e.getMessage());
			e.printStackTrace();
			added = new JsonResponse();
			added.setMessage("Could not be added to Cache.");
		    added.setStatusCode("500");
		}  
	    return added;
	}
	
	
}
