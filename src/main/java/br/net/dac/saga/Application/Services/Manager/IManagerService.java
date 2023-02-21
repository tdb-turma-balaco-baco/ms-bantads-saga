package br.net.dac.saga.Application.Services.Manager;

import br.net.dac.saga.Domain.Events.Auth.Response.ManagerAuthCreatedEvent;
import br.net.dac.saga.Domain.Events.Auth.Response.RemovedManagerAccessEvent;
import br.net.dac.saga.Domain.Events.Client.Response.ClientCreatedEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.ChangeManagerClientsEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.CreateManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.UpdateManagerEvent;

public interface IManagerService {

    void processCreateManagerEvent(CreateManagerEvent event);
    void processSelectMaxClientEvent(ManagerAuthCreatedEvent eventResponse);
    void processSelectMinClientEvent(ClientCreatedEvent eventResponse);
    void processUpdateManagerEvent(UpdateManagerEvent event);
    void processChangeManagerClients(ChangeManagerClientsEvent event);
    void processRemoveManagerAccess(RemovedManagerAccessEvent event);
}
