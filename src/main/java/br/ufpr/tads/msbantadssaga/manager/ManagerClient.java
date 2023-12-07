package br.ufpr.tads.msbantadssaga.manager;

import br.ufpr.tads.msbantadssaga.manager.request.CreateManager;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "manager", url = "localhost:8080/api/manager")
public interface ManagerClient {
    @PostMapping
    ResponseEntity<?> create(@Valid @NonNull CreateManager request);
}
