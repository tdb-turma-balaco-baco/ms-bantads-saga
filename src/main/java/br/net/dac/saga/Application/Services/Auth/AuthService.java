package br.net.dac.saga.Application.Services.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.net.dac.saga.Application.Abstraction.IMessageSender;
import br.net.dac.saga.Domain.Events.Account.Response.ChangedStatusAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Response.CreatedAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Response.SwapAllManagerClientsEvent;
import br.net.dac.saga.Domain.Events.Auth.Request.CreateClientAuthEvent;
import br.net.dac.saga.Domain.Events.Auth.Request.CreateManagerAuthEvent;
import br.net.dac.saga.Domain.Events.Auth.Request.GeneratePasswordEvent;
import br.net.dac.saga.Domain.Events.Auth.Request.RemoveManagerAccessEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.CreatedManagerEvent;

@Service
public class AuthService implements IAuthService {

    @Autowired
    IMessageSender _messageSender;

    @Value("${auth.client.queue}")
    private String authQueue;

    @Value("${auth.manager.queue}")
    private String authManagerQueue;

    @Override
    public void processCreateClientAuthEvent(CreatedAccountEvent eventResponse) {
        CreateClientAuthEvent event = new CreateClientAuthEvent(eventResponse.getEmail(),
                eventResponse.getName(),
                eventResponse.getCpf());
        _messageSender.sendMessage(authQueue, event);
    }

    @Override
    public void processGeneratePasswordEvent(ChangedStatusAccountEvent eventResponse) {
        GeneratePasswordEvent event = new GeneratePasswordEvent(eventResponse.getCpf());
        _messageSender.sendMessage(authQueue, event);
    }

    @Override
    public void processCreateManagerAuthEvent(CreatedManagerEvent eventResponse) {
        CreateManagerAuthEvent event = new CreateManagerAuthEvent(eventResponse.getEmail(),
                eventResponse.getName(), eventResponse.getCpf());
        _messageSender.sendMessage(authManagerQueue, event);
    }

    @Override
    public void processRemoveManagerAccess(SwapAllManagerClientsEvent eventResponse) {
        RemoveManagerAccessEvent event = new RemoveManagerAccessEvent(eventResponse.getCpf());
        _messageSender.sendMessage(authManagerQueue, event);
    }

}
