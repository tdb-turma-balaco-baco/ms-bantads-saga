package br.net.dac.saga.Domain.Events.Notification.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class CreatedManagerEmailEvent extends DomainEvent {
    private String password;
    private String email;
    private String name;
    private String cpf;
    
    public CreatedManagerEmailEvent(String password, String email, String name, String cpf) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.cpf = cpf;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
}
