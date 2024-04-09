package ru.project.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.project.model.Account;

import java.util.List;

public interface AccountRepo extends CrudRepository<Account, Long> {
    @Query(value="select a.* from account a where account_pool_id=:poolId and bussy=false  order by id limit 10", nativeQuery = true)
    List<Account> findFirstPageFreeAcc(Long poolId);

    @Query(value="select a.* from account a where account_pool_id=:poolId and bussy=false and id > :lastId  order by id limit 10", nativeQuery = true)
    List<Account> findNextPageFreeAcc(Long poolId, Long lastId);

    @Query(value="select a.* from account a where id=:accountId for update nowait", nativeQuery = true)
    Account findByIdLock(Long accountId);



}
