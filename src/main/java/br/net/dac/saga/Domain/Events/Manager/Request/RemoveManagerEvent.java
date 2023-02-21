package br.net.dac.saga.Domain.Events.Manager.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class RemoveManagerEvent extends DomainEvent{
    private String cpf;
    
    public RemoveManagerEvent(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
