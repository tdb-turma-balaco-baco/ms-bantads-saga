package br.net.dac.saga.Domain.Events.Account.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class UpdateAccountManagerEvent extends DomainEvent{
    private String cpf;
    private String name;

    public UpdateAccountManagerEvent(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
