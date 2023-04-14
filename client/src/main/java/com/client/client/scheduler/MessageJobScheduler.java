package com.client.client.scheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.client.client.service.MessageService;

@Component
public class MessageJobScheduler {

    private MessageService messageService;

    @Autowired
    public MessageJobScheduler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Scheduled(fixedDelay = 1000L)
    public void sendMessageJob() {
        messageService.sendMessage();
    }

}
