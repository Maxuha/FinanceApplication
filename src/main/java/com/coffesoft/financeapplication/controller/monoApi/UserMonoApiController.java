package com.coffesoft.financeapplication.controller.monoApi;

import com.coffesoft.financeapplication.component.MonoApiComponent;
import com.coffesoft.financeapplication.model.monobank.AccountMono;
import com.coffesoft.financeapplication.model.monobank.StatementMono;
import com.coffesoft.financeapplication.model.monobank.UserMono;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserMonoApiController {
    private static final Logger logger = Logger.getLogger(UserMonoApiController.class);
    private final MonoApiComponent monoApiComponent;

    public UserMonoApiController(MonoApiComponent monoApiComponent) {
        this.monoApiComponent = monoApiComponent;
    }

    @PostMapping(value = "/mono/user/api")
    public UserMono createUserMono(@RequestHeader("X-Token") String token) {
        return monoApiComponent.createUserMono(token);
    }

    @PostMapping(value = "/mono/statement/api")
    public List<StatementMono> createStatementMono(@RequestHeader("X-Token") String token,
                                                   @RequestBody AccountMono accountMono) {
        return monoApiComponent.createStatementMono(token, accountMono);
    }
}
