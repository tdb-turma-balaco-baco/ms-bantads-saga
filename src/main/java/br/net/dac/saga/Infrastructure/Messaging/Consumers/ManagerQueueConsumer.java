package br.net.dac.saga.Infrastructure.Messaging.Consumers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.net.dac.saga.Application.Services.Account.IAccountService;
import br.net.dac.saga.Application.Services.Auth.IAuthService;
import br.net.dac.saga.Domain.Events.Manager.Response.ChangedManagerClientsEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.CreatedManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.SelectedManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.SelectedTopEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.UpdatedManagerEvent;

@Component
@RabbitListener(queues = {"${manager-response.queue}"})
public class ManagerQueueConsumer {
    @Autowired
    IAuthService _authService;

    @Autowired
    IAccountService _accountService;

    @RabbitHandler
    public void receiveSave(@Payload CreatedManagerEvent eventResponse){
        _authService.processCreateManagerAuthEvent(eventResponse);
    }

    @RabbitHandler
    public void receiveSelected(@Payload SelectedTopEvent eventResponse){
        _accountService.processSwapOneManagerEvent(eventResponse);
    }

    @RabbitHandler //UpdateManager
    public void receiveUpdated(@Payload UpdatedManagerEvent eventResponse){
        _accountService.processUpdatedManagerEvent(eventResponse);
    }

    @RabbitHandler //ChangeManagerClients
    public void receiveUpdated(@Payload ChangedManagerClientsEvent eventResponse){
        _accountService.processSwapAllManagerEvent(eventResponse);
    }

    @RabbitHandler //SelectMinManager
    public void receiveSelectedMin(@Payload SelectedManagerEvent eventResponse){
        _accountService.processCreateAccountEvent(eventResponse);
    }

    
    
}
