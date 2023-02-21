package br.net.dac.saga.Domain.Events.Account.Request;

import br.net.dac.saga.Domain.Events.DomainEvent;

public class SwapManagerEvent extends DomainEvent{
    private String oldManagerCpf;
    private String cpf;
    private String name;
    private boolean swapAll;

    public SwapManagerEvent(String oldManagerCpf, String cpf, String name, boolean swapAll) {
        this.oldManagerCpf = oldManagerCpf;
        this.cpf = cpf;
        this.name = name;
        this.swapAll = swapAll;
    }
    public String getOldManagerCpf() {
        return oldManagerCpf;
    }
    public void setOldManagerCpf(String oldManagerCpf) {
        this.oldManagerCpf = oldManagerCpf;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isSwapAll() {
        return swapAll;
    }
    public void setSwapAll(boolean swapAll) {
        this.swapAll = swapAll;
    }
}
