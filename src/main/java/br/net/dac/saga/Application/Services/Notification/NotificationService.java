package br.net.dac.saga.Application.Services.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.net.dac.saga.Application.Abstraction.IMessageSender;
import br.net.dac.saga.Domain.Events.Account.Response.ChangedStatusAccountEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.ClientPasswordCreatedEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.ManagerAuthCreatedEvent;
import br.net.dac.saga.Domain.Events.Notification.Request.ClientApprovedEvent;
import br.net.dac.saga.Domain.Events.Notification.Request.ClientRejectedEvent;
import br.net.dac.saga.Domain.Events.Notification.Request.CreatedManagerEmailEvent;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    IMessageSender _messageSender;

    @Value("${notification.queue}")
    private String notificationQueue;

    @Override
    public void processClientRejectedEvent(ChangedStatusAccountEvent eventResponse) {
        ClientRejectedEvent event = new ClientRejectedEvent(eventResponse.getEmail(),
         eventResponse.getName(), eventResponse.getStatusReason());

        _messageSender.sendMessage(notificationQueue, event);
    }

    @Override
    public void processCreateClientFailEvent() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void processClientApprovedEvent(ClientPasswordCreatedEvent eventResponse) {
        ClientApprovedEvent event = new ClientApprovedEvent(eventResponse.getPassword(),
         eventResponse.getEmail(), eventResponse.getName());

         _messageSender.sendMessage(notificationQueue, event);
        
    }

    @Override
    public void processCreatedManagerCredentials(ManagerAuthCreatedEvent eventResponse) {
        CreatedManagerEmailEvent event = new CreatedManagerEmailEvent(eventResponse.getPassword(),
                                            eventResponse.getEmail(),
                                            eventResponse.getName(),
                                            eventResponse.getCpf());
        
        _messageSender.sendMessage(notificationQueue, event);                                   
    }
    
}
