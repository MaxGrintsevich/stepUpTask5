package ru.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.model.Account;
import ru.project.model.AccountPool;
import ru.project.exceptions.NoDataFoundException;
import ru.project.repo.AccountPoolRepo;
import ru.project.repo.AccountRepo;

import java.util.List;

@Service
public class AccountPoolService {
    @Autowired
    AccountPoolRepo poolRepo;
    @Autowired
    AccountRepo accountRepo;
    private AccountPool getPoolOrThrown(String branchCode, String currencyCode, String mdmCode, String priorityCode, String registryTypeCode){
        AccountPool accountPool = poolRepo.findPool(branchCode,currencyCode,mdmCode,priorityCode,registryTypeCode);
        if (accountPool == null){
            throw new NoDataFoundException("Не найден пул [account_pool]: "
                    + "branchCode='" + branchCode + "'; "
                    + "currencyCode='" + currencyCode + "'; "
                    + "mdmCode='" + mdmCode+ "'; "
                    + "priorityCode='" + priorityCode + "'; "
                    + "registryTypeCode='" + registryTypeCode + "' ");
        }
        return accountPool;
    }

    private Account getAccountWithLock(List<Account> accounts){
        for (Account account: accounts) {
            Account acc = accountRepo.findByIdLock(account.getId());
            if (! acc.getBusy()) return acc;
        }
        return null;
    }

    private Account getAccountOrThrown(AccountPool pool){
        List<Account> accounts =  accountRepo.findFirstPageFreeAcc(pool.getId());
        Account acc = null;
        while (! accounts.isEmpty()){
            acc = getAccountWithLock(accounts);
            if (! acc.getBusy()) return acc;
            accounts = accountRepo.findNextPageFreeAcc(pool.getId(), accounts.get(accounts.size()-1).getId());
        }

        throw new NoDataFoundException("Пул ID: " + pool.getId() + " нет свободных счетов!");
    }

    public Account getNextAccount(String branchCode
                                , String currencyCode
                                , String mdmCode
                                , String priorityCode
                                , String registryTypeCode
                                )
    {
        AccountPool pool = getPoolOrThrown(branchCode, currencyCode, mdmCode, priorityCode, registryTypeCode);
        Account account = getAccountOrThrown(pool);
        account.setBusy(true);
        accountRepo.save(account);
        return account;
    };
}
