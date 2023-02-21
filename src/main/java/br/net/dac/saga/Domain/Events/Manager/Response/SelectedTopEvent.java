package br.net.dac.saga.Domain.Events.Manager.Response;

public class SelectedTopEvent {
    private String managerName;
    private String managerCpf;
    private String oldManagerCpf;
    private boolean swapAll;
    
    public SelectedTopEvent(String managerName, String managerCpf, String oldManagerCpf, boolean swapAll) {
        this.managerName = managerName;
        this.managerCpf = managerCpf;
        this.oldManagerCpf = oldManagerCpf;
        this.swapAll = swapAll;
    }
    
    public SelectedTopEvent() {
    }

    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public String getManagerCpf() {
        return managerCpf;
    }
    public void setManagerCpf(String managerCpf) {
        this.managerCpf = managerCpf;
    }
    public String getOldManagerCpf() {
        return oldManagerCpf;
    }
    public void setOldManagerCpf(String oldManagerCpf) {
        this.oldManagerCpf = oldManagerCpf;
    }
    public boolean isSwapAll() {
        return swapAll;
    }
    public void setSwapAll(boolean swapAll) {
        this.swapAll = swapAll;
    }
}
