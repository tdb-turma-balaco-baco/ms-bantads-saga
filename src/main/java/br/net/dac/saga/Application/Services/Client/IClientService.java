package br.net.dac.saga.Application.Services.Client;

import br.net.dac.saga.Domain.Events.Client.Request.CreateClientEvent;
import br.net.dac.saga.Domain.Events.Client.Request.UpdateClientEvent;

public interface IClientService {
    void processCreateClientEvent(CreateClientEvent event);
    void processUpdateClientEvent(UpdateClientEvent event);

}
