package br.net.dac.saga.Application.Services.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.net.dac.saga.Application.Abstraction.IMessageSender;
import br.net.dac.saga.Domain.Events.Client.Request.CreateClientEvent;
import br.net.dac.saga.Domain.Events.Client.Request.UpdateClientEvent;

@Service
public class ClientService implements IClientService{

    @Value("${client.queue}")
    private String clientQueue;

    @Autowired
    IMessageSender _messageSender;
    
    @Override
    public void processCreateClientEvent(CreateClientEvent event) {
        _messageSender.sendMessage(clientQueue, event);        
    }

    @Override
    public void processUpdateClientEvent(UpdateClientEvent event) {
        _messageSender.sendMessage(clientQueue, event);
        
    }

    
}
