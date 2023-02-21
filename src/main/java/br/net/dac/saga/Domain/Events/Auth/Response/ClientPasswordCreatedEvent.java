package br.net.dac.saga.Domain.Events.Auth.Response;

public class ClientPasswordCreatedEvent {
    private String cpf;
    private String email;
    private String password;
    private String name;

    public ClientPasswordCreatedEvent(String cpf, String email, String password, String name) {
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public ClientPasswordCreatedEvent() {
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
