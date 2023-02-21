package br.net.dac.saga.Domain.Events.Manager.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class SelectMaxClientEvent extends DomainEvent {
    private String cpf;
    
    public SelectMaxClientEvent(String cpf) {
        this.cpf = cpf;
    }

    public SelectMaxClientEvent() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
