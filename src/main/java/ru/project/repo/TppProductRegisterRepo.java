package ru.project.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.project.model.TppProductRegister;

import java.util.List;

public interface TppProductRegisterRepo extends CrudRepository<TppProductRegister, Long> {
    @Query(value="select id from tpp_product_register tpr where tpr.product_id=:instanceId", nativeQuery = true)
    List<Long> getRegisterIdsByProduct(Long instanceId);

    TppProductRegister findFirstByProductIdAndType(Long productId, String type);
}
