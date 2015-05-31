package com;

import com.journaldev.spring.di.consumer.MyApplication;
import com.journaldev.spring.di.services.MessageService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Framework core concepts are “Dependency Injection” and “Aspect Oriented Programming“
 * This tutorial is aimed to provide dependency injection example in Spring with both annotation based configuration and XML file based configuration.
 * I will also provide JUnit test case example for the application, since easy testability is one of the major benefits of dependency injection.
 *
 * http://www.journaldev.com/2410/spring-dependency-injection-example-with-annotations-and-xml-configuration
 */
@Configuration
@ComponentScan(value="com.journaldev.spring.di.consumer")
public class MyApplicationTest {

    private AnnotationConfigApplicationContext context = null;

    @Bean
    public MessageService getMessageService() {
        return new MessageService(){

            public boolean sendMessage(String msg, String rec) {
                System.out.println("Mock Service");
                return true;
            }
        };
    }

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(MyApplicationTest.class);
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }

    @Test
    public void test() {
        MyApplication app = context.getBean(MyApplication.class);
        Assert.assertTrue(app.processMessage("Hi Pankaj", "pankaj@abc.com"));
    }
}
