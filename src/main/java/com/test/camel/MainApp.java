package com.test.camel;

import org.apache.camel.main.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.camel.cache.service.CustomCacheService;
import com.test.camel.db.dao.SubscriberDao;

/**
 * A Camel Application
 */
public class MainApp {

	
    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
    	
    	ApplicationContext springCtx = new ClassPathXmlApplicationContext("application-context.xml");
    	SubscriberDao subscriberDao = (SubscriberDao)springCtx.getBean("subdao");
        Main main = new Main();
        
        
        CustomCacheService custSrv = new CustomCacheService();
        custSrv.setSubDao(subscriberDao);
        
        
        
        main.bind("subscriberDao", subscriberDao);
        main.bind("customCacheService", custSrv);
        main.addRouteBuilder(new RestRouteBuilder());
       
        main.addRouteBuilder(new JsonRouteBuilder());
        main.run(args);
    }

}

