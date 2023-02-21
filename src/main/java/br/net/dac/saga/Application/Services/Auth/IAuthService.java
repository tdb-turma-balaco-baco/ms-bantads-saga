package br.net.dac.saga.Application.Services.Auth;

import br.net.dac.saga.Domain.Events.Account.Response.ChangedStatusAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Response.CreatedAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Response.SwapAllManagerClientsEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.CreatedManagerEvent;

public interface IAuthService {

    void processCreateManagerAuthEvent(CreatedManagerEvent eventResponse);
    void processCreateClientAuthEvent(CreatedAccountEvent eventReponse);
    void processGeneratePasswordEvent(ChangedStatusAccountEvent eventResponse);
    void processRemoveManagerAccess(SwapAllManagerClientsEvent eventResponse);
}
