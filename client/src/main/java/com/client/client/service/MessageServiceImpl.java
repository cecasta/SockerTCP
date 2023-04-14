package com.client.client.service;

import java.time.LocalDateTime;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.client.gateway.TcpClientGateway;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    private TcpClientGateway tcpClientGateway;

    @Autowired
    public MessageServiceImpl(TcpClientGateway tcpClientGateway) {
        this.tcpClientGateway = tcpClientGateway;
    }

    @Override
    public void sendMessage() {
        String message = LocalDateTime.now().toString();
        LOGGER.info("Send message: {}", message);
        byte[] responseBytes = tcpClientGateway.send(message.getBytes());
        String response = new String(responseBytes);
        LOGGER.info("Receive response: {}", response);
    }

	@Override
	public String sendMessageAsesorVirtual(String message) {
        LOGGER.info("Send message Asesor virtual: {}", message);
        byte[] responseBytes = tcpClientGateway.send(message.getBytes());
        String response = new String(responseBytes);
        LOGGER.info("Receive response: {}", response);
		return response;
	}

}