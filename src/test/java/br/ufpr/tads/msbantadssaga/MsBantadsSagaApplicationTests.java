package br.ufpr.tads.msbantadssaga;

import br.ufpr.tads.msbantadssaga.manager.ManagerService;
import br.ufpr.tads.msbantadssaga.saga.SagaController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MsBantadsSagaApplicationTests {
    @Autowired private SagaController controller;
    @Autowired private ManagerService managerService;

    @Test
    void contextLoads() {
        assertNotNull(controller);
        assertNotNull(managerService);
    }

}
