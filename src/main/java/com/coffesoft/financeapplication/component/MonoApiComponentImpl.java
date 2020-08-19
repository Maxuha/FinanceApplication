package com.coffesoft.financeapplication.component;

import com.coffesoft.financeapplication.exception.MaskedPanMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.*;
import com.coffesoft.financeapplication.model.monobank.api.AccountMonoApi;
import com.coffesoft.financeapplication.model.monobank.api.StatementMonoApi;
import com.coffesoft.financeapplication.model.monobank.api.UserMonoApi;
import com.coffesoft.financeapplication.service.monobank.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Component
public class MonoApiComponentImpl implements MonoApiComponent {
    private static final Integer MAX_SECONDS = 2678400;
    private static final LocalDateTime FINISH_DATE = LocalDateTime.of(2017, 1, 1, 0, 0);
    private static final Logger logger = Logger.getLogger(MonoApiComponentImpl.class);
    private final UserMonoApiService userMonoApiService;
    private final StatementMonoApiService statementMonoApiService;
    private final UserMonoService userMonoService;
    private final AccountMonoService accountMonoService;
    private final MaskedPanMonoService maskedPanMonoService;
    private final CurrencyCodeService currencyCodeService;
    private final MccService mccService;
    private final StatementMonoService statementMonoService;

    public MonoApiComponentImpl(UserMonoApiService userMonoApiService, StatementMonoApiService statementMonoApiService,
                                UserMonoService userMonoService, AccountMonoService accountMonoService,
                                MaskedPanMonoService maskedPanMonoService, CurrencyCodeService currencyCodeService,
                                MccService mccService, StatementMonoService statementMonoService) {
        this.userMonoApiService = userMonoApiService;
        this.statementMonoApiService = statementMonoApiService;
        this.userMonoService = userMonoService;
        this.accountMonoService = accountMonoService;
        this.maskedPanMonoService = maskedPanMonoService;
        this.currencyCodeService = currencyCodeService;
        this.mccService = mccService;
        this.statementMonoService = statementMonoService;
    }

    @Override
    public List<StatementMono> createStatementMono(String token, AccountMono accountMono) {
        List<StatementMono> statementMonoAll = new ArrayList<>();
        LocalDateTime to = LocalDateTime.now();
        LocalDateTime from = to.minusSeconds(MAX_SECONDS);
        while (!FINISH_DATE.isAfter(from)) {
            List<StatementMono> statementMonoList = createStatementMonoOfMonth(token, accountMono,
                    from.atZone(ZoneId.systemDefault()).toEpochSecond(), to.atZone(ZoneId.systemDefault()).toEpochSecond());
            statementMonoAll.addAll(statementMonoList);
            to = from;
            from = to.minusSeconds(MAX_SECONDS);
            System.out.println(!FINISH_DATE.isAfter(from));
            System.out.println("To: " + to + " from: " + from);
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                break;
            }
        }
        return statementMonoAll;
    }

    @Override
    public List<StatementMono> createStatementMonoOfMonth(String token, AccountMono accountMono, Long from, Long to) {
        List<StatementMonoApi> statementMonoApiList = statementMonoApiService.
                getStatementMonoByTokenForAccountOfMouthFromMonoApi(token, accountMono, from, to);
        return statementMonoService.saveStatementListForAccountMono(getStatementMonoListFromStatementMonoApi(statementMonoApiList, accountMono));
    }

    @Override
    public UserMono createUserMono(String token) {
        UserMonoApi userMonoApi = userMonoApiService.getUserMonoByTokenFromMonoApi(token);
        UserMono userMono = new UserMono(userMonoApi, token);
        List<AccountMono> accountMonoList = createAccountMonoList(userMonoApi.getAccounts(), userMono);
        userMono.setAccountMonoList(accountMonoList);
        return userMonoService.saveUserMono(userMono);
    }

    private Mcc createMcc(Integer mccValue) {
        Mcc mcc = new Mcc(mccValue);
        return mccService.saveMcc(mcc);
    }

    private List<MaskedPanMono> createMaskedPanMono(List<String> maskedPanList, AccountMono accountMono) {
        List<MaskedPanMono> maskedPanMonoList = getMaskedPanMonoFromApi(maskedPanList, accountMono);
        try {
            return maskedPanMonoService.saveMaskedPanMonoListForAccountMono(maskedPanMonoList);
        } catch (MaskedPanMonoNotFoundException e) {
            logger.warn("Api request: " + e.getMessage());
        }
        return null;
    }

    private CurrencyCode createCurrencyCode(Integer currencyCodeValue) {
        return currencyCodeService.saveCurrencyCode(getCurrencyCodeFromCurrencyCodeValue(currencyCodeValue));
    }

    private List<AccountMono> createAccountMonoList(List<AccountMonoApi> accounts, UserMono userMono) {
        return accountMonoService.saveAccountsMonoForUserMono(getAccountMonoListFromAccountMonoApi(accounts, userMono));
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

    private List<AccountMono> getAccountMonoListFromAccountMonoApi(List<AccountMonoApi> accounts, UserMono userMono) {
        List<AccountMono> accountMonoList = new ArrayList<>();
        for (AccountMonoApi accountMonoApi : accounts) {
            CurrencyCode currencyCode = createCurrencyCode(accountMonoApi.getCurrencyCode());
            AccountMono accountMono = new AccountMono(accountMonoApi, currencyCode, userMono);
            List<MaskedPanMono> maskedPanMonoList = createMaskedPanMono(accountMonoApi.getMaskedPan(), accountMono);
            accountMono.setMaskedPanMonoList(maskedPanMonoList);
            accountMonoList.add(accountMono);
        }
        return accountMonoList;
    }

    private List<StatementMono> getStatementMonoListFromStatementMonoApi(List<StatementMonoApi> statementMonoApiList, AccountMono accountMono) {
        List<StatementMono> statementMonoList = new ArrayList<>();
        StatementMono statementMono;
        for (StatementMonoApi statementMonoApi : statementMonoApiList) {
            Mcc mcc = createMcc(statementMonoApi.getMcc());
            CurrencyCode currencyCode = createCurrencyCode(statementMonoApi.getCurrencyCode());
            statementMono = new StatementMono(statementMonoApi, mcc, currencyCode, accountMono);
            statementMonoList.add(statementMono);
        }
        return statementMonoList;
    }
}
