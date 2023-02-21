package br.net.dac.saga.Domain.Events.Auth.Response;

public class ManagerAuthCreatedEvent {
    private String cpf;
    private String email;
    private String name;
    private String password;

    public ManagerAuthCreatedEvent(String cpf, String email, String name, String password) {
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public ManagerAuthCreatedEvent() {
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
