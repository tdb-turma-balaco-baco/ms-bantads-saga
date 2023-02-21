package br.net.dac.saga.Domain.Events.Manager.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class SelectMinClientEvent extends DomainEvent{
    private String email;
    private String name;
    private String cpf;
    private Double wage;

    public SelectMinClientEvent(String email, String name, String cpf, Double wage) {
        this.email = email;
        this.name = name;
        this.cpf = cpf;
        this.wage = wage;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public Double getWage() {
        return wage;
    }
    public void setWage(Double wage) {
        this.wage = wage;
    }
}
