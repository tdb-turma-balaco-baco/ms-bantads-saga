package br.net.dac.saga.Domain.Events.Client.Response;

public class ClientCreatedEvent {
    private String name;
    private String cpf;
    private Double wage;
    private String email;
    
    public ClientCreatedEvent(String name, String cpf, Double wage, String email) {
        this.name = name;
        this.cpf = cpf;
        this.wage = wage;
        this.email = email;
    }

    public ClientCreatedEvent() {
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
