package com.test.camel.processor;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.test.camel.domain.Subscribers;

public class JsonProcessor implements Processor{

	
	  @Override public void process(Exchange exchange) throws Exception {
	  System.out.println("exchange is being processed."+exchange);
	  
	  @SuppressWarnings("unchecked") List<Subscribers> subList =
	  (List<Subscribers>) exchange.getIn().getBody();
	 
	  for(Subscribers sub:subList) { //Subscribers sub =
	  
	  System.out.println("Subscriber received is:"+((Subscribers)sub).toString());
	 // exchange.getIn().setBody(sub);
	  }
	  
	  }
	 
	
	/*
	 * @Override public void process(Exchange exchange) throws Exception {
	 * System.out.println("exchange is being processed."+exchange);
	 * 
	 * @SuppressWarnings("unchecked") Subscribers sub =
	 * exchange.getIn().getBody(Subscribers.class);
	 * 
	 * 
	 * 
	 * System.out.println("Subscriber received is:"+sub.toString());
	 * 
	 * 
	 * }
	 */

}
