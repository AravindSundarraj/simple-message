package com.test.notification.awsmessage.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.test.notification.awsmessage.domain.Product;
import com.test.notification.awsmessage.domain.ReceiveMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleQueueService {

    @Autowired
    AmazonSQS amazonSQS;

    public void sendMessage(Product message) {
        System.out.println("Message ==>> " + message);
        String m = null;
        ObjectMapper obj = new ObjectMapper();
        try {
            m = obj.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        amazonSQS.sendMessage("https://sqs.us-east-1.amazonaws.com/524770157680/test_2_queue",
                m);
    }

    public void receiveMessage(){
        ReceiveMessage rm = new ReceiveMessage();
        rm.setQueueUrl("https://sqs.us-east-1.amazonaws.com/524770157680/test_2_queue");
       ReceiveMessageResult rmr = amazonSQS.receiveMessage(rm);
       rmr.getMessages().stream().forEach(
               e ->{
                   System.out.println("Get the MSG : "+e.getBody() + " MSG-ID :" +e.getMessageId());
               }
       );
    }
}
