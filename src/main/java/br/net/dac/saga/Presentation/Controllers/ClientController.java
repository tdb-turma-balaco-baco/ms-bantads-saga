package br.net.dac.saga.Presentation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.dac.saga.Presentation.Contracts.Client.ClientDTO;
import jakarta.validation.Valid;
import br.net.dac.saga.Application.Services.Account.IAccountService;
import br.net.dac.saga.Application.Services.Client.IClientService;
import br.net.dac.saga.Domain.Events.Account.Request.UpdateStatusAccountEvent;
import br.net.dac.saga.Domain.Events.Client.Request.Address;
import br.net.dac.saga.Domain.Events.Client.Request.CreateClientEvent;
import br.net.dac.saga.Domain.Events.Client.Request.UpdateClientEvent;
import br.net.dac.saga.Presentation.Contracts.Client.AccountStatusDTO;
import br.net.dac.saga.Presentation.Contracts.Client.AddressDTO;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    IAccountService accountService;

    @Autowired
    IClientService clientService;

    //Envia para CreateClientEvent -> (Client)
    //CreatedClientEvent recebe e envia para -> SelectMinClientEvent (Manager)
    //Recebe SelectedManagerEvent e envia para -> CreateAccountEvent (Account)
    //Recebe CreatedAccountEvent e envia para -> CreateClientAuht (Auth)
    @PostMapping("/save")
    public ResponseEntity<?> saveClient(@Valid @RequestBody ClientDTO clientDTO)
    {
        try{
            CreateClientEvent event = new CreateClientEvent(clientDTO.getName(), 
            clientDTO.getEmail(), 
            clientDTO.getCpf(), 
            clientDTO.getPhone(), 
            clientDTO.getWage(), 
            mapDtoToAddressEvent(clientDTO.getAddress()));

            clientService.processCreateClientEvent(event);
            return ResponseEntity.ok("Operação realizada!");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    //UpdateClientEvent -> (Client)
    //Recebe UpdatedClientEvent e envia para -> UpdateAccountEvent (Account)
    @PostMapping("/update")
    public ResponseEntity<?> updateClient(@Valid @RequestBody ClientDTO clientDTO)
    {
        try{
            UpdateClientEvent event = new UpdateClientEvent(clientDTO.getName(), 
            clientDTO.getEmail(), 
            clientDTO.getCpf(), 
            clientDTO.getPhone(), 
            clientDTO.getWage(), 
            mapDtoToAddressEvent(clientDTO.getAddress()));

            clientService.processUpdateClientEvent(event);
            return ResponseEntity.ok("sd");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    //UpdateStatusAaccountEvent - approved true (Account)
    //Recebe ChangedStatusAccountEvent approved true e encaminha para -> GeneratePasswordEvent (Auth)
    //Recebe ClientPasswordCreatedEvent e encaminha para -> ClientApprovedEvent (Notification)
    @PostMapping("/approve")
    public ResponseEntity<?> approveClient(@Valid @RequestBody AccountStatusDTO accountStatusDTO)
    {
        try{
            UpdateStatusAccountEvent event = new UpdateStatusAccountEvent(accountStatusDTO.getAccountNumber(),
                                                true, accountStatusDTO.getStatusReason());

            accountService.processUpdateStatusAccountEvent(event);
            return ResponseEntity.ok("Operação realizada!");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("reject")
    public ResponseEntity<?> rejectClient(@Valid @RequestBody AccountStatusDTO accountStatusDTO)
    {
        try{
            UpdateStatusAccountEvent event = new UpdateStatusAccountEvent(accountStatusDTO.getAccountNumber(),
                                        false, accountStatusDTO.getStatusReason());

            accountService.processUpdateStatusAccountEvent(event);
            return ResponseEntity.ok("Operação realizada!");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    private Address mapDtoToAddressEvent(AddressDTO dto){
        Address address = new Address(dto.getType(), 
                            dto.getStreet(), 
                            dto.getNumber(), 
                            dto.getComplement(), 
                            dto.getCep(), 
                            dto.getCity(),
                            dto.getState());
        return address;
    }
}
