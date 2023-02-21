package br.net.dac.saga.Domain.Events.Manager.Response;

public class UpdatedManagerEvent {
    private String name;
    private String cpf;

    public UpdatedManagerEvent(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }
    
    public UpdatedManagerEvent() {
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
}
