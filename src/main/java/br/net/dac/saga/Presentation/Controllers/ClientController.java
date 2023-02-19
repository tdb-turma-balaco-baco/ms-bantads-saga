package br.net.dac.saga.Presentation.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.dac.saga.Presentation.Contracts.Client.ClientDTO;
import jakarta.validation.Valid;
import br.net.dac.saga.Presentation.Contracts.Client.AccountStatusDTO;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {

    @PostMapping("/save")
    public ResponseEntity<?> saveClient(@Valid @RequestBody ClientDTO clientDTO)
    {
        try{
            return ResponseEntity.ok("sd");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateClient(@Valid @RequestBody ClientDTO clientDTO)
    {
        try{
            return ResponseEntity.ok("sd");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/approve")
    public ResponseEntity<?> approveClient(AccountStatusDTO accountStatusDTO)
    {
        try{
            return ResponseEntity.ok("sd");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("reject")
    public ResponseEntity<?> rejectClient(AccountStatusDTO accountStatusDTO)
    {
        try{
            return ResponseEntity.ok("sd");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }
}
