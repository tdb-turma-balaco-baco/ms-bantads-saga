package br.net.dac.saga.Infrastructure.Messaging.Consumers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.net.dac.saga.Application.Services.Auth.IAuthService;
import br.net.dac.saga.Application.Services.Notification.INotificationService;
import br.net.dac.saga.Domain.Events.Account.Response.ChangedStatusAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Response.CreatedAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Response.SwapAllManagerClientsEvent;

@Component
@RabbitListener(queues = {"${account-response.queue}"})
public class AccountQueueConsumers {

    @Autowired
    IAuthService _authService;

    @Autowired
    INotificationService _notificationService;

    @RabbitHandler
    public void receiveChangedStatus(@Payload ChangedStatusAccountEvent eventResponse){

        if(eventResponse.getStatus().equals("APPROVED"))
        {
            _authService.processGeneratePasswordEvent(eventResponse);
        }else{
            _notificationService.processClientRejectedEvent(eventResponse);
        }
    }

    @RabbitHandler //SwapManagerEventAll
    public void receiveSwapAllManager(@Payload SwapAllManagerClientsEvent eventResponse){
        _authService.processRemoveManagerAccess(eventResponse);
    }

    @RabbitHandler //CreateAccountEvent
    public void receiveCreatedAccount(@Payload CreatedAccountEvent eventResponse){
        _authService.processCreateClientAuthEvent(eventResponse);
    }
}
