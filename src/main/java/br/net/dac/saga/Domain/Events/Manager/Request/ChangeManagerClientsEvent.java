package br.net.dac.saga.Domain.Events.Manager.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class ChangeManagerClientsEvent extends DomainEvent {
    private String cpfRemover;

    public ChangeManagerClientsEvent(String cpfRemover) {
        this.cpfRemover = cpfRemover;
    }
    
    public ChangeManagerClientsEvent() {
    }

    public String getCpfRemover() {
        return cpfRemover;
    }

    public void setCpfRemover(String cpfRemover) {
        this.cpfRemover = cpfRemover;
    }
}
