package br.net.dac.saga.Presentation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.dac.saga.Application.Services.Manager.IManagerService;
import br.net.dac.saga.Domain.Events.Manager.Request.ChangeManagerClientsEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.CreateManagerEvent;
import br.net.dac.saga.Domain.Events.Manager.Request.UpdateManagerEvent;
import br.net.dac.saga.Presentation.Contracts.Manager.ManagerDTO;
import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/manager")
public class ManagerController {
    
    @Autowired
    IManagerService _managerService;
    
    //Envia para CreateManagerEvent -> (Manager)
    //CreatedManagerEnvet recebe e envia para -> CreateManagerAuthEvent (Auth)
    //Recebe ManagerAuthCreatedEvent e envia para -> CreatedManagerEmailEvent (Notification)
    //Recebe ManagerAuthCreatedEvent e envia para -> SelectMaxClientEvent (Manager)
    //Recebe SelectedTopEvent e envia para -> SwapManagerEvent swappall false (Account)
    @PostMapping("/save")
    public ResponseEntity<?> saveManager(@Valid @RequestBody ManagerDTO managerDTO)
    {
        try{
            CreateManagerEvent event = new CreateManagerEvent(managerDTO.getName(), managerDTO.getEmail(),
            managerDTO.getCpf(), managerDTO.getPhone());

            _managerService.processCreateManagerEvent(event); //OK
            return ResponseEntity.ok("Operação realizada!");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    //UpdateManagerEvent -> (Manager)
    //Recebe UpdatedManagerEvent e envia para -> UpdateManagerEvent (Account)
    @PostMapping("/update")
    public ResponseEntity<?> updateManager(@Valid @RequestBody ManagerDTO managerDTO)
    {
        try{
            UpdateManagerEvent event = new UpdateManagerEvent(managerDTO.getId(),
                                            managerDTO.getName(), 
                                            managerDTO.getEmail(), 
                                            managerDTO.getCpf(), 
                                            managerDTO.getPhone());

            _managerService.processUpdateManagerEvent(event); //OK
            return ResponseEntity.ok("Operação realizada!");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    //Envia para ChangeManagerClients -> (Manager)
    //ChangedManagerClients recebe e envia para -> SwapManagerEvent - swapAll true (Account)
    //Recebe SwapPerformedManagerEvent e envia para -> BlockManagerEvent (Auth)
    //Recebe BlockedManagerEvent e envia para -> RemoveManager (Manager)
    @PostMapping("/{cpf}/remove")
    public ResponseEntity<?> removeManager(@PathVariable String cpf)
    {
        try{
            ChangeManagerClientsEvent event = new ChangeManagerClientsEvent(cpf);
            _managerService.processChangeManagerClients(event);
            return ResponseEntity.ok("Operação realizada!");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }
}
