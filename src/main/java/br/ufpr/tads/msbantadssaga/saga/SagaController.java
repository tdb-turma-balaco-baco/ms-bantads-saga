package br.ufpr.tads.msbantadssaga.saga;

import br.ufpr.tads.msbantadssaga.manager.ManagerService;
import br.ufpr.tads.msbantadssaga.manager.request.CreateManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(SagaController.URL)
@RequiredArgsConstructor
public class SagaController {
    public static final String URL = "/api/saga";
    private final ManagerService managerService;

    @PostMapping("/manager")
    public ResponseEntity<?> createManager(@RequestBody @Valid @NonNull CreateManager createManager) {
        log.debug("[request] createManager {}", createManager);
        var internalError = new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "there was a problem creating the manager");

        Optional<Long> managerId = this.managerService.create(createManager);

        if (managerId.isPresent()) {
            return ResponseEntity.created(URI.create(URL + "/" + managerId.get())).build();
        }

        log.error("[error] createManager '{}' problem with the manager microservice", createManager.email());
        throw internalError;
    }
}
