package com.test.notification.awsmessage.controller;

import com.test.notification.awsmessage.domain.Product;
import com.test.notification.awsmessage.service.SampleQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/notification")
public class MessageController {

    @Autowired
    SampleQueueService sampleQueueService;

    @PostMapping(value="/send")
    public void send(@RequestBody Product msg){
        sampleQueueService.sendMessage(msg);
    }


    @GetMapping(value="/retrieve")
    public void getMessage(){
        sampleQueueService.receiveMessage();
    }
}
