package com.test.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.test.camel.domain.Subscribers;
import com.test.camel.processor.JsonProcessor;

public class DbRouteBuilder extends RouteBuilder{

	
	@Override
	public void configure() throws Exception {
		
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat();
		jsonDataFormat.useList();
		jsonDataFormat.setUnmarshalType(Subscribers.class);
		
		
		from("file:src/data?noop=true")
		.log("Picked up ${file:name}")
		.choice()		     
			.when(simple("${file:name.ext} contains 'json'"))
			    .routeId("DBRoute")
				.log("A JSON File")
				   .unmarshal(jsonDataFormat) .process(new JsonProcessor()) 
				   .split(body())
				   .marshal().json(JsonLibrary.Jackson) .log("${body}")
					 .to("bean:subscriberDao?method=saveSubscriber")
					 .log("Object: :::: ${body}")
				       .end();
	}

}
