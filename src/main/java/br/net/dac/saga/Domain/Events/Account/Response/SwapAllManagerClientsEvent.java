package br.net.dac.saga.Domain.Events.Account.Response;

public class SwapAllManagerClientsEvent {
    private String email;
    private String cpf;

    public SwapAllManagerClientsEvent() {
    }
    public SwapAllManagerClientsEvent(String email, String cpf) {
        this.email = email;
        this.cpf = cpf;
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

    
}
