package com.journaldev.spring.di.consumer;

import com.journaldev.spring.di.services.MessageService;

/**
 * Let’s write a consumer class for the message services.
 * We will have two consumer classes:
 * One with Spring annotations for autowiring and another without annotation and wiring configuration will be provided in the XML configuration file.
 *
 * This one is the: One without annotation and wiring configuration will be provided in the XML configuration file.
 */
public class MyXMLApplication {

	private MessageService service;

	//constructor-based dependency injection
//	public MyXMLApplication(MessageService svc) {
//		this.service = svc;
//	}
	
	//setter-based dependency injection
	public void setService(MessageService svc){
		this.service = svc;
	}

	public boolean processMessage(String msg, String rec) {
		// some magic like validation, logging etc
		return this.service.sendMessage(msg, rec);
	}
}
