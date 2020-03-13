package com.test.camel;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.processor.LoopProcessor;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.test.camel.db.entity.SubscribersE;
import com.test.camel.domain.Subscribers;
import com.test.camel.processor.JsonProcessor;
import com.test.camel.utils.MappingUtils;

public class JsonRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		
		// enable Jackson json type converter
		getContext().getGlobalOptions().put("CamelJacksonEnableTypeConverter", "true");
		// allow Jackson json to convert to pojo types also (by default jackson only converts to String and other simple types)
		getContext().getGlobalOptions().put("CamelJacksonTypeConverterToPojo", "true");
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat();
		jsonDataFormat.useList();
		jsonDataFormat.setUnmarshalType(Subscribers.class);
		

		
		
		from("file:src/data?noop=true")
		.log("Picked up ${file:name}")
		.choice()		     
			.when(simple("${file:name.ext} contains 'json'"))
			    .routeId("JsonRoute")
				.log("A JSON File")
				   .unmarshal(jsonDataFormat) .process(new JsonProcessor()) 
				   .split(body())
				   .marshal()
				   .json(JsonLibrary.Jackson) 
				   .log("${body}")
				   .to("bean:subscriberDao?method=saveSubscriber")
				   .to("jetty:http://0.0.0.0:8080/rest/custcahe/addToCache")
				   .log("REST Status: :::: ${body}")
				       .end();
			/*.otherwise()
				.log("Not a JSON File") 
				.to("file:target/messages/others");*/
		 

		
	}
	
}
