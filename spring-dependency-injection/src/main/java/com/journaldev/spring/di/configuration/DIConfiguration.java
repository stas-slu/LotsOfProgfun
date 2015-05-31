package com.journaldev.spring.di.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.journaldev.spring.di.services.EmailService;
import com.journaldev.spring.di.services.MessageService;

/**
 * For annotation based configuration, we need to write a Configurator class that will be used to inject the actual implementation bean to the component property.
 *
 * @Configuration annotation is used to let Spring know that it’s a Configuration class.
 *
 * @ComponentScan annotation is used with @Configuration annotation to specify the packages to look for Component classes.
 *
 * @Bean annotation is used to let Spring framework know that this method should be used to get the bean implementation to inject in Component classes.
 */
@Configuration
@ComponentScan(value={"com.journaldev.spring.di.consumer"})
public class DIConfiguration {

	@Bean
	public MessageService getMessageService(){
		return new EmailService();
	}
}
