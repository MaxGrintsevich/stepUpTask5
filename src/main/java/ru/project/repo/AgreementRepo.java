package ru.project.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.project.model.Agreement;

import java.util.List;

public interface AgreementRepo extends CrudRepository<Agreement, Long> {
    List<Agreement> findByNumber(String number);
    @Query(value="select id from agreement a where product_id=:instanceId", nativeQuery = true)
    List<Long> getAgreementIdsByProduct(Long instanceId);
}
