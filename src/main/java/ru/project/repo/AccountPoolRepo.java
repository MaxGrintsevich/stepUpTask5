package ru.project.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.project.model.AccountPool;

public interface AccountPoolRepo extends CrudRepository<AccountPool, Long> {
    @Query(value = "SELECT p.*  FROM  account_pool p  " +
                   "WHERE branch_code=:branchCode " +
                            "and currency_code=:currencyCode  " +
                            "and mdm_code=:mdmCode " +
                            "and priority_code=:priorityCode " +
                            "and registry_type_code=:registerTypeCode", nativeQuery = true)
    AccountPool findPool(String branchCode
                      , String currencyCode
                      , String mdmCode
                      , String priorityCode
                      , String registerTypeCode);
}
