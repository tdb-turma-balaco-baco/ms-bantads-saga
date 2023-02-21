package br.net.dac.saga.Application.Services.Account;

import br.net.dac.saga.Domain.Events.Account.Request.UpdateStatusAccountEvent;
import br.net.dac.saga.Domain.Events.Client.Response.ClientUpdatedEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.ChangedManagerClientsEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.SelectedManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.SelectedTopEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.UpdatedManagerEvent;

public interface IAccountService {
   void processUpdateStatusAccountEvent(UpdateStatusAccountEvent status);
   void processSwapOneManagerEvent(SelectedTopEvent eventResponse);
   void processUpdatedManagerEvent(UpdatedManagerEvent eventResponse);
   void processSwapAllManagerEvent(ChangedManagerClientsEvent eventResponse);
   void processCreateAccountEvent(SelectedManagerEvent eventResponse);
   void processUpdateAccountEvent(ClientUpdatedEvent eventReponse);
}
