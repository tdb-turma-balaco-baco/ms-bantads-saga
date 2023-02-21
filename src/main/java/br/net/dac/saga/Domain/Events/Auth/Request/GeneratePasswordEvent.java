package br.net.dac.saga.Domain.Events.Auth.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class GeneratePasswordEvent extends DomainEvent {
    private String cpf;
    
    public GeneratePasswordEvent(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
