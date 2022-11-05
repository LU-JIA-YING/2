package com.example.Spring.controller.activeMQ;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

//  queue
@Component
public class ActiveMQClient {

    @Autowired
    private JmsTemplate jmsTemplate;

    private static final Logger logger = Logger.getLogger(ActiveMQClient.class);

    @JmsListener(destination = "response.queue", containerFactory = "queueConnectionFactory")
    public void consumeMessageQueue(String response) {

        logger.info("Message received from activemq queue---\n" + response);
        System.out.println("=================================================\n");
//        System.out.println("Message received from activemq queue---\n" + response);
    }

}
