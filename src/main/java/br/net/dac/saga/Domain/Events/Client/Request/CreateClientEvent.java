package br.net.dac.saga.Domain.Events.Client.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class CreateClientEvent extends DomainEvent {
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private Double wage;
    private Address address;
    
    public CreateClientEvent(String name, String email, String cpf, String phone, Double wage, Address address) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.wage = wage;
        this.address = address;
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

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
