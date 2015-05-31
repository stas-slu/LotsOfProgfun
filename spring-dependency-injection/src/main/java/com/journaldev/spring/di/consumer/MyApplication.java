package com.journaldev.spring.di.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journaldev.spring.di.services.MessageService;

/**
 * Let’s write a consumer class for the message services.
 * We will have two consumer classes:
 * One with Spring annotations for autowiring and another without annotation and wiring configuration will be provided in the XML configuration file.
 *
 * This one is the: One with Spring annotations for autowiring
 */
@Component //@Component annotation is added to the class, so that when Spring framework will scan for the components, this class will be treated as component
public class MyApplication {

    //field-based dependency injection
    //@Autowired
    private MessageService service;

//	constructor-based dependency injection
//	@Autowired
//	public MyApplication(MessageService svc){
//		this.service=svc;
//	}

    /**
     * @Autowired annotation is used to let Spring know that autowiring is required.
     * This can be applied to field, constructor and methods.
     * This annotation allows us to implement constructor-based, field-based or method-based dependency injection in our components.
     *
     * For our example, I am using method-based dependency injection. You can uncomment the constructor method to switch to constructor based dependency injection.
     */
    @Autowired
    public void setService(MessageService svc){
        this.service=svc;
    }

    public boolean processMessage(String msg, String rec){
        //some magic like validation, logging etc
        return this.service.sendMessage(msg, rec);
    }
}
