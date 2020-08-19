package com.coffesoft.financeapplication.controller.monoApi;

import com.coffesoft.financeapplication.model.monobank.AccountMono;
import com.coffesoft.financeapplication.model.monobank.CurrencyCode;
import com.coffesoft.financeapplication.model.monobank.MaskedPanMono;
import com.coffesoft.financeapplication.model.monobank.UserMono;
import com.coffesoft.financeapplication.model.monobank.api.AccountMonoApi;
import com.coffesoft.financeapplication.model.monobank.api.UserMonoApi;
import com.coffesoft.financeapplication.service.monobank.*;
import com.coffesoft.financeapplication.util.PostRequest;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserMonoApiController {
    private static final Logger logger = Logger.getLogger(UserMonoApiController.class);
    private final UserMonoApiService userMonoApiService;
    private final UserMonoService userMonoService;
    private final AccountMonoService accountMonoService;
    private final MaskedPanMonoService maskedPanMonoService;
    private final CurrencyCodeService currencyCodeService;

    public UserMonoApiController(UserMonoApiService userMonoApiService, UserMonoService userMonoService, AccountMonoService accountMonoService, MaskedPanMonoService maskedPanMonoService, CurrencyCodeService currencyCodeService) {
        this.userMonoApiService = userMonoApiService;
        this.userMonoService = userMonoService;
        this.accountMonoService = accountMonoService;
        this.maskedPanMonoService = maskedPanMonoService;
        this.currencyCodeService = currencyCodeService;
    }

    @GetMapping(value = "/mono/user/api")
    public UserMono createUserMono(@RequestHeader("X-Token") String token) {
        UserMonoApi userMonoApi = userMonoApiService.getUserMonoByTokenFromMonoApi(token);
        UserMono userMono = new UserMono(userMonoApi, token);
        List<AccountMono> accountMonoList = createAccountMonoList(userMono, userMonoApi.getAccounts());
        userMono.setAccountMonoList(accountMonoList);
        return userMonoService.saveUserMono(userMono);
    }

    private List<MaskedPanMono> createMaskedPanMono(List<String> maskedPanList, AccountMono accountMono) {
        List<MaskedPanMono> maskedPanMonoList = getMaskedPanMonoFromApi(maskedPanList, accountMono);
        return maskedPanMonoService.saveMaskedPanMonoListForAccountMono(maskedPanMonoList);
    }

    private CurrencyCode createCurrencyCode(Integer currencyCodeValue) {
        return currencyCodeService.saveCurrencyCode(getCurrencyCodeFromCurrencyCodeValue(currencyCodeValue));
    }

    private List<AccountMono> createAccountMonoList(UserMono userMono, List<AccountMonoApi> accounts) {
        return accountMonoService.saveAccountsMonoForUserMono(getAccountMonoListFromAccountMonoApi(userMono, accounts));
    }

    private List<MaskedPanMono> getMaskedPanMonoFromApi(List<String> maskedPanList, AccountMono accountMono) {
        List<MaskedPanMono> maskedPanMonoList = new ArrayList<>();
        for (String maskedPan : maskedPanList) {
            maskedPanMonoList.add(new MaskedPanMono(maskedPan, accountMono));
        }
        return maskedPanMonoList;
    }

    private CurrencyCode getCurrencyCodeFromCurrencyCodeValue(Integer currencyCodeValue) {
        return new CurrencyCode(currencyCodeValue);
    }

    private List<AccountMono> getAccountMonoListFromAccountMonoApi(UserMono userMono, List<AccountMonoApi> accounts) {
        List<AccountMono> accountMonoList = new ArrayList<>();
        for (AccountMonoApi accountMonoApi : accounts) {
            CurrencyCode currencyCode = createCurrencyCode(accountMonoApi.getCurrencyCode());
            AccountMono accountMono = new AccountMono(accountMonoApi.getId(), currencyCode,
                    accountMonoApi.getCashbackType(), accountMonoApi.getBalance(), accountMonoApi.getCreditLimit(),
                    accountMonoApi.getType(), userMono);
            List<MaskedPanMono> maskedPanMonoList = createMaskedPanMono(accountMonoApi.getMaskedPan(), accountMono);
            accountMono.setMaskedPanMono(maskedPanMonoList);
            accountMonoList.add(accountMono);
        }
        return accountMonoList;
    }
}
