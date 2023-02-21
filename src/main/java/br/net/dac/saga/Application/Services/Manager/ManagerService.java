package br.net.dac.saga.Application.Services.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.net.dac.saga.Application.Abstraction.IMessageSender;
import br.net.dac.saga.Domain.Events.Auth.Response.ManagerAuthCreatedEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.RemovedManagerAccessEvent;
import br.net.dac.saga.Domain.Events.Client.Response.ClientCreatedEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.ChangeManagerClientsEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.CreateManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.RemoveManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.SelectMaxClientEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.SelectMinClientEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.UpdateManagerEvent;

@Service
public class ManagerService implements IManagerService{

    @Autowired
    IMessageSender _messageSender;

    @Value("${manager.queue}")
    private String managerQueue;
    
    @Override
    public void processCreateManagerEvent(CreateManagerEvent event) {
        _messageSender.sendMessage(managerQueue, event);
    }

    @Override
    public void processSelectMaxClientEvent(ManagerAuthCreatedEvent eventResponse) {
        SelectMaxClientEvent event = new SelectMaxClientEvent(eventResponse.getCpf());
        _messageSender.sendMessage(managerQueue, event);
    }

    @Override
    public void processUpdateManagerEvent(UpdateManagerEvent event) {
        _messageSender.sendMessage(managerQueue, event);
    }

    @Override
    public void processChangeManagerClients(ChangeManagerClientsEvent event) {
        _messageSender.sendMessage(managerQueue, event);
    }

    @Override
    public void processRemoveManagerAccess(RemovedManagerAccessEvent event) {
        RemoveManagerEvent eventDomain = new RemoveManagerEvent(event.getCpf());
        _messageSender.sendMessage(managerQueue, eventDomain);
    }

    @Override
    public void processSelectMinClientEvent(ClientCreatedEvent eventResponse) {
        SelectMinClientEvent event = new SelectMinClientEvent(eventResponse.getEmail(), 
                                        eventResponse.getName(), 
                                        eventResponse.getCpf(), 
                                        eventResponse.getWage());
        _messageSender.sendMessage(managerQueue, event);        
    }

}
