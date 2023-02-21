package br.net.dac.saga.Domain.Events.Account.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class UpdateStatusAccountEvent extends DomainEvent {
    private long accountNumber;
    private boolean approved;
    private String statusReason;
    
    public UpdateStatusAccountEvent(long accountNumber, boolean approved, String statusReason) {
        this.accountNumber = accountNumber;
        this.approved = approved;
        this.statusReason = statusReason;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public boolean isApproved() {
        return approved;
    }
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    public String getStatusReason() {
        return statusReason;
    }
    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }
}
