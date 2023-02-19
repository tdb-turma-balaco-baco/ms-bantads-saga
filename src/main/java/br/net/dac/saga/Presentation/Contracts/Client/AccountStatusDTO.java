package br.net.dac.saga.Presentation.Contracts.Client;

import jakarta.validation.constraints.NotNull;

public class AccountStatusDTO {
    @NotNull
    private Long accountNumber;
    private String statusReason;

    public String getStatusReason() {
        return statusReason;
    }
    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }
    public Long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    
}
