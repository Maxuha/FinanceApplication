package com.coffesoft.financeapplication.controller.monoApi;

import com.coffesoft.financeapplication.component.MonoApiComponent;
import com.coffesoft.financeapplication.exception.MaskedPanMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.*;
import com.coffesoft.financeapplication.service.monobank.StatementMonoServiceThread;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonoApiController {
    private static final Logger logger = Logger.getLogger(MonoApiController.class);
    private final MonoApiComponent monoApiComponent;

    public MonoApiController(MonoApiComponent monoApiComponent) {
        this.monoApiComponent = monoApiComponent;
    }

    @PostMapping(value = "/mono/user/statement/api")
    public ResponseEntity<?> createStatementMono(@RequestHeader("X-Token") String token,
                                              @RequestBody AccountMono accountMono) {
        StatementMonoServiceThread statementMonoServiceThread = new StatementMonoServiceThread(monoApiComponent);
        statementMonoServiceThread.setToken(token);
        statementMonoServiceThread.setAccountMono(accountMono);
        statementMonoServiceThread.start();
        return ResponseEntity.ok("OK");
    }

    @PostMapping(value = "/mono/user/statement/api/{from}/{to}")
    public List<StatementMono> createStatementMonoOfMonth(@RequestHeader("X-Token") String token,
                                                          @RequestBody AccountMono accountMono,
                                                          @PathVariable Long from, @PathVariable Long to) {
        return monoApiComponent.createStatementMonoOfMonth(token, accountMono, from, to);
    }

    @PostMapping(value = "/mono/user/api")
    public UserMono createUserMono(@RequestHeader("X-Token") String token) throws MaskedPanMonoNotFoundException {
        return monoApiComponent.createUserMono(token);
    }
}
