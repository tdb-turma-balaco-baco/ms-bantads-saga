package br.net.dac.saga.Domain.Events.Client.Response;

public class ClientUpdatedEvent {
    private String name;
    private String cpf;
    private String email;
    private Double wage;
    
    public ClientUpdatedEvent() {
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
