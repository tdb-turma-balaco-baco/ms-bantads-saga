package br.net.dac.saga.Domain.Events.Auth.Response;

public class RemovedManagerAccessEvent {
    private String cpf;

    public RemovedManagerAccessEvent() {
    }

    public RemovedManagerAccessEvent(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
