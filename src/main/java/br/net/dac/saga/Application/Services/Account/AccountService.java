package br.net.dac.saga.Application.Services.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.net.dac.saga.Application.Abstraction.IMessageSender;
import br.net.dac.saga.Domain.Events.Account.Request.CreateAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Request.SwapManagerEvent;
import br.net.dac.saga.Domain.Events.Account.Request.UpdateAccountEvent;
import br.net.dac.saga.Domain.Events.Account.Request.UpdateAccountManagerEvent;
import br.net.dac.saga.Domain.Events.Account.Request.UpdateStatusAccountEvent;
import br.net.dac.saga.Domain.Events.Client.Response.ClientUpdatedEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.ChangedManagerClientsEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.SelectedManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.SelectedTopEvent;
import br.net.dac.saga.Domain.Events.Manager.Response.UpdatedManagerEvent;

@Service
public class AccountService implements IAccountService{

    @Autowired
    IMessageSender _messageSender;

    @Value("${account.queue}")
    private String accountQueue;

    @Override
    public void processUpdateStatusAccountEvent(UpdateStatusAccountEvent status) {
        _messageSender.sendMessage(accountQueue, status);
    }

    @Override
    public void processSwapOneManagerEvent(SelectedTopEvent eventResponse) {
        SwapManagerEvent event = new SwapManagerEvent(eventResponse.getOldManagerCpf(),
                                        eventResponse.getManagerCpf(),
                                        eventResponse.getManagerName(),
                                        false);
         _messageSender.sendMessage(accountQueue, event);
    }

    @Override
    public void processUpdatedManagerEvent(UpdatedManagerEvent eventResponse) {
        UpdateAccountManagerEvent event = new UpdateAccountManagerEvent(eventResponse.getCpf(), 
                                            eventResponse.getName());   
                                            
        _messageSender.sendMessage(accountQueue, event);
    }

    @Override
    public void processSwapAllManagerEvent(ChangedManagerClientsEvent eventResponse) {
        SwapManagerEvent event = new SwapManagerEvent(eventResponse.getOldManagerCpf(), 
        eventResponse.getManagerCpf(), eventResponse.getManagerName(), true);
        
        _messageSender.sendMessage(accountQueue, event);
    }

    @Override
    public void processCreateAccountEvent(SelectedManagerEvent eventResponse) {
        CreateAccountEvent event = new CreateAccountEvent(
            eventResponse.getName(),
            eventResponse.getCpf(),
            eventResponse.getEmail(),
            eventResponse.getManagerCpf(),
            eventResponse.getManagerName(),
            eventResponse.getWage()   
        );
        _messageSender.sendMessage(accountQueue, event);
    }

    @Override
    public void processUpdateAccountEvent(ClientUpdatedEvent eventReponse) {
        UpdateAccountEvent event = new UpdateAccountEvent(eventReponse.getName(), 
                                        eventReponse.getCpf(), 
                                        eventReponse.getEmail(),
                                        eventReponse.getWage());
        _messageSender.sendMessage(accountQueue, event);
        
    }

}
