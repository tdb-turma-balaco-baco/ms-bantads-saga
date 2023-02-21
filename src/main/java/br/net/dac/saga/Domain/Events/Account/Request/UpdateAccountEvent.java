package br.net.dac.saga.Domain.Events.Account.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class UpdateAccountEvent extends DomainEvent {
    private String name;
    private String cpf;
    private String email;
    private Double wage;
    
    public UpdateAccountEvent(String name, String cpf, String email, Double wage) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.wage = wage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getWage() {
        return wage;
    }
    public void setWage(Double wage) {
        this.wage = wage;
    }
}
