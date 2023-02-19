package br.net.dac.saga.Presentation.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.dac.saga.Presentation.Contracts.Manager.ManagerDTO;

@CrossOrigin
@RestController
@RequestMapping("/manager")
public class ManagerController {
    
    @PostMapping("/save")
    public ResponseEntity<?> saveManager(ManagerDTO managerDTO)
    {
        try{
            return ResponseEntity.ok("sd");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateManager(ManagerDTO managerDTO)
    {
        try{
            return ResponseEntity.ok("sd");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/{cpf}/remove")
    public ResponseEntity<?> removeManager(@PathVariable String cpf)
    {
        try{
            return ResponseEntity.ok("sd");
        }catch(Exception ex){
            return ResponseEntity.status(500).build();
        }
    }
}
