package br.net.dac.saga.Application.Services.Notification;

import br.net.dac.saga.Domain.Events.Account.Response.ChangedStatusAccountEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.ClientPasswordCreatedEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.ManagerAuthCreatedEvent;

public interface INotificationService {
    /*
     *         idClassMapping.put("ClientApprovedEvent", ClientApprovedEvent.class);
        idClassMapping.put("CreatedManagerEvent", CreatedManagerEvent.class);
        idClassMapping.put("ClientRejectedEvent", ClientRejectedEvent.class);
        idClassMapping.put("CreateClientFailEvent", CreateClientFailEvent.class);
     */

     void processClientApprovedEvent(ClientPasswordCreatedEvent eventResponse);
     void processClientRejectedEvent(ChangedStatusAccountEvent eventResponse);
     void processCreateClientFailEvent();
     void processCreatedManagerCredentials(ManagerAuthCreatedEvent eventResponse);
}
