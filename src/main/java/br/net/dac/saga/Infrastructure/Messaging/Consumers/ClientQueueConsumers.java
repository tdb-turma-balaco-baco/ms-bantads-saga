package br.net.dac.saga.Infrastructure.Messaging.Consumers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.net.dac.saga.Application.Services.Account.IAccountService;
import br.net.dac.saga.Application.Services.Manager.IManagerService;
import br.net.dac.saga.Domain.Events.Client.Response.ClientCreatedEvent;
import br.net.dac.saga.Domain.Events.Client.Response.ClientUpdatedEvent;

@Component
@RabbitListener(queues = {"${client-response.queue}"})
public class ClientQueueConsumers {

    @Autowired
    IManagerService _managerService;

    @Autowired
    IAccountService _accountService;
    
    @RabbitHandler
    public void receiveCreatedClient(@Payload ClientCreatedEvent eventResponse){
        _managerService.processSelectMinClientEvent(eventResponse);
    }

    @RabbitHandler
    public void receiveCreatedClient(@Payload ClientUpdatedEvent eventResponse){
        _accountService.processUpdateAccountEvent(eventResponse);
    }
}
