package br.net.dac.saga.Domain.Events.Manager.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class UpdateManagerEvent extends DomainEvent {
    private Long managerId;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    
    public UpdateManagerEvent() {
    }
    public UpdateManagerEvent(Long managerId, String name, String email, String cpf, String phone) {
        this.managerId = managerId;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Long getManagerId() {
        return managerId;
    }
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}
