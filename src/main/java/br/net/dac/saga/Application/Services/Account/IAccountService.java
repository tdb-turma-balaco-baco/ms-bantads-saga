package br.net.dac.saga.Application.Services.Account;

public interface IAccountService {
        /*
     * 
     *         Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("CreateAccountEvent", CreateAccountEvent.class);
        idClassMapping.put("UpdateAccountEvent", UpdateAccountEvent.class);
        idClassMapping.put("UpdateStatusAccountEvent", UpdateStatusAccountEvent.class);
        idClassMapping.put("UpdateManagerEvent", UpdateManagerEvent.class);
        idClassMapping.put("SwapManagerEvent", SwapManagerEvent.class);

        idClassMapping.put("ChangedStatusAccountEvent", ChangedStatusAccountEvent.class);
        idClassMapping.put("CreatedAccountEvent", CreatedAccountEvent.class);
        idClassMapping.put("ErrorAccountEvent", ErrorAccountEvent.class);
     */

     void processCreatedAccountEvent();
     void processChangedStatusAccountEvent();
     void processErrorAccountEvent();
}
