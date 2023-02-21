package br.net.dac.saga.Domain.Events.Auth.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class RemoveManagerAccessEvent extends DomainEvent {
    private String cpf;
    
    public RemoveManagerAccessEvent(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
