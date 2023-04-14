package com.server.socket.service;

public interface MessageService {

    byte[] processMessage(byte[] message);
    
    
    byte[] processMessageAsesorVirtual(byte[] message);

}
