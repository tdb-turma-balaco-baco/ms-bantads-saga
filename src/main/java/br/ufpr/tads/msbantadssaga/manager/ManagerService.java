package br.ufpr.tads.msbantadssaga.manager;

import br.ufpr.tads.msbantadssaga.manager.request.CreateManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerClient client;

    public Optional<Long> create(@Valid @NonNull CreateManager createManager) {
        log.debug("[creating] create {}", createManager);
        ResponseEntity<?> response = this.client.create(createManager);

        if (response.getStatusCode().is2xxSuccessful()) {
            URI location = response.getHeaders().getLocation();

            try {
                if (Objects.isNull(location)) {
                    throw new IllegalStateException("response location header is null");
                }

                String[] path = location.getPath().split("/");
                if (path.length < 3) {
                    throw new IllegalStateException("can't retrieve created manager id");
                }

                return Optional.of(Long.parseLong(path[3]));
            } catch (IllegalStateException | NumberFormatException e) {
                log.error("[creating] problem parsing the manager id from the URI '{}': {}", location, e.getMessage());
                return Optional.empty();
            }
        } else {
            log.debug("[creating] error {}", createManager);

            if (response.getStatusCode().is4xxClientError()) {
                log.warn("[creating] problem with the request creating '{}': {}", createManager.email(), response.getBody());
            }

            if (response.getStatusCode().is5xxServerError()) {
                log.error("[creating] manager microservice error creating '{}': {}", createManager.email(), response.getBody());
            }
        }

        return Optional.empty();
    }
}
