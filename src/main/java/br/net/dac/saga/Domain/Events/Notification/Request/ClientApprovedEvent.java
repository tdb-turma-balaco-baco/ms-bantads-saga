package br.net.dac.saga.Domain.Events.Notification.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class ClientApprovedEvent extends DomainEvent {
    private String password;
    private String email;
    private String name;

    public ClientApprovedEvent(String password, String email, String name) {
        this.password = password;
        this.email = email;
        this.name = name;
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

}
