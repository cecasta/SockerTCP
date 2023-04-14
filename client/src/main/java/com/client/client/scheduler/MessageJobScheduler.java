package com.client.client.scheduler;


import java.util.Scanner;

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
    	System.out.println("Ingresar numero de telefono: ");
    	Scanner sc = new Scanner(System.in);
    	String mobileNo = sc.nextLine();
    	
        messageService.sendMessageAsesorVirtual(mobileNo);
    }

}
