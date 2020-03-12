package com.test.camel;

import org.apache.camel.main.Main;

import com.test.camel.cache.service.CustomCacheService;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        
        main.bind("customCacheService", new CustomCacheService());
        main.addRouteBuilder(new RestRouteBuilder());
        main.addRouteBuilder(new JsonRouteBuilder());
        main.run(args);
    }

}

