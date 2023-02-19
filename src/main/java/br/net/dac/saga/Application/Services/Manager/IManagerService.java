package br.net.dac.saga.Application.Services.Manager;

public interface IManagerService {
    /*
     *         idClassMapping.put("CreateManagerEvent", SaveManagerEvent.class);
        idClassMapping.put("RemoveManagerEvent", RemoveManagerEvent.class);
        idClassMapping.put("UpdateManagerEvent", UpdateManagerEvent.class);

        idClassMapping.put("ChangeManagerClients", ChangeManagerClients.class);
        idClassMapping.put("SelectMaxCientEvent", SelectMaxClientEvent.class);
        idClassMapping.put("SelectMinClientEvent", SelectMinClientEvent.class);

        idClassMapping.put("ChangedManagerClientsEvent", ChangedManagerClientsEvent.class);
        idClassMapping.put("CreatedManagerEvent", CreatedManagerEvent.class);
        idClassMapping.put("SelectedManagerEvent", SelectedManagerEvent.class);
        idClassMapping.put("SelectedTopEvent", SelectedTopEvent.class);
        idClassMapping.put("UpdatedManagerEvent", UpdatedManagerEvent.class);
     */
    void processChangedManagerClientsEvent();
    void processCreatedManagerEvent();
    void processSelectedManagerEvent();
    void processSelectedTopEvent();
    void processUpdatedManagerEvent();
}
