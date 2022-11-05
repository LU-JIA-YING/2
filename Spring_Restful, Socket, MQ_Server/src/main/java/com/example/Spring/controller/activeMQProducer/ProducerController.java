package com.example.Spring.controller.activeMQProducer;

import com.example.Spring.service.TransferService;
import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.TextMessage;

//  queue
@RestController
public class ProducerController {

    @Autowired
    private TransferService transferService;

    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = "request.queue", containerFactory = "queueConnectionFactory")
    @SendTo("response.queue")
    public String getRequest(String request) throws Exception {
        String response = transferService.getResponse(request);
        return response;
    }
}
