package br.net.dac.saga.Domain.Events.Notification.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class ClientRejectedEvent extends DomainEvent{
    private String email;
    private String name;
    private String rejectReason;

    public ClientRejectedEvent(String email, String name, String rejectReason) {
        this.email = email;
        this.name = name;
        this.rejectReason = rejectReason;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
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
