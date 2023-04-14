package com.server.socket.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Override
    public byte[] processMessage(byte[] message) {
        String messageContent = new String(message);
        LOGGER.info("Receive message: {}", messageContent);
        String responseContent = String.format("Message \"%s\" is processed", messageContent);
        return responseContent.getBytes();
    }

	@Override
	public byte[] processMessageAsesorVirtual(byte[] message) {
        String messageContent = new String(message);
        String messageResponse;
        LOGGER.info("Receive message Server: {}", messageContent);
        if(messageContent.equals("300123")) {
        	messageResponse = "Carlos,Calle 53 79 105,Medellin";
        }else {
        	messageResponse = "Persona dueña de ese número telefónico no existe";
        }
        	
        String responseContent = String.format("Message \"%s\" is processed", messageResponse);
        return responseContent.getBytes();
	}

}
