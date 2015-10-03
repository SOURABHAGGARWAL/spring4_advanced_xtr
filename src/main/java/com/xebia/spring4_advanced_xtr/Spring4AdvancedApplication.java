package com.xebia.spring4_advanced_xtr;

import java.io.File;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;

@EnableJms
@SpringBootApplication
public class Spring4AdvancedApplication {

	@Bean //Strictly speaking this bean is not necessary as boot creates a default
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }
    
    public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(Spring4AdvancedApplication.class, args);
    	
    	Spring4AdvancedApplication spring4AdvancedApplication = new Spring4AdvancedApplication();
    	spring4AdvancedApplication.sendMessage(context);
    }
    
	public void sendMessage(ConfigurableApplicationContext context){
		// Clean out any ActiveMQ data from a previous run
	    FileSystemUtils.deleteRecursively(new File("activemq-data"));
	    
	 // Send a message
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("ping!");
            }
        };
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println("Sending a new message.");
        jmsTemplate.send("mailbox-destination", messageCreator);
	}
}
