package com.test.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

import com.test.camel.domain.JsonResponse;
import com.test.camel.domain.Subscribers;

/**
 * A Camel Java DSL Router
 */
public class RestRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
	/*
	 * public void configure() {
	 * 
	 * // here is a sample which processes the input files // (leaving them in place
	 * - see the 'noop' flag) // then performs content based routing on the message
	 * using XPath from("file:src/data?noop=true") .choice()
	 * .when(xpath("/person/city = 'London'")) .log("UK message")
	 * .to("file:target/messages/uk") .otherwise() .log("Other message")
	 * .to("file:target/messages/others"); }
	 */
    
    @Override
    public void configure() throws Exception {
        
        // use jetty for rest service
        restConfiguration().component("jetty").port("8080").contextPath("rest")
                // turn on json binding
                .bindingMode(RestBindingMode.json)
                // turn off binding error on empty beans
                .dataFormatProperty("disableFeatures", "FAIL_ON_EMPTY_BEANS")
                // enable swagger api documentation
                //.apiContextPath("api-doc")
                .enableCORS(true);

        // define the rest service
        rest("/custcahe").consumes("application/json").produces("application/json")
            .get("/getFromCache/{code}").outType(Subscribers.class).description("Returns the items currently in the cache depending upon hashcode as key")
                .to("bean:customCacheService?method=getFromCache(${header.code})")
            // get accepts CartDto
            .post("/addToCache").type(Subscribers.class).description("Adds the object to the cache")
                .to("bean:customCacheService?method=addToCache");
        
        //Not required to delete from cache as of now
		/*
		 * .delete().description("Removes the item from the cache")
		 * .param().name("itemId").description("Id of item to remove").endParam()
		 * .to("bean:CustomCacheService?method=removeFromCache");
		 */
    }

}
