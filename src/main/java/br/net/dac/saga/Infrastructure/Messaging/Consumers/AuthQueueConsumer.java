package br.net.dac.saga.Infrastructure.Messaging.Consumers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.net.dac.saga.Application.Services.Manager.IManagerService;
import br.net.dac.saga.Application.Services.Notification.INotificationService;
import br.net.dac.saga.Domain.Events.Auth.Response.ClientPasswordCreatedEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.ManagerAuthCreatedEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.RemovedManagerAccessEvent;

@Component
@RabbitListener(queues = {"${auth.queue.producer}"})
public class AuthQueueConsumer{
    @Autowired
    INotificationService _notificationService;

    @Autowired
    IManagerService _managerService;

    @RabbitHandler
    public void receivePasswordCreated(@Payload ClientPasswordCreatedEvent eventResponse){
        _notificationService.processClientApprovedEvent(eventResponse);
    }

    @RabbitHandler
    public void receiveManagerCreated(@Payload ManagerAuthCreatedEvent eventResponse){
        _notificationService.processCreatedManagerCredentials(eventResponse);
        _managerService.processSelectMaxClientEvent(eventResponse);
    }

    @RabbitHandler //RemoveManagerCredentials
    public void receiveRemoved(@Payload RemovedManagerAccessEvent eventResponse){
        _managerService.processRemoveManagerAccess(eventResponse);
    }
}
