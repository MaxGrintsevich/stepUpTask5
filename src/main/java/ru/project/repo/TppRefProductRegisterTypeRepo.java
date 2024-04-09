package ru.project.repo;

import org.springframework.data.repository.CrudRepository;
import ru.project.model.TppRefProductRegisterType;

import java.util.List;

public interface TppRefProductRegisterTypeRepo extends CrudRepository<TppRefProductRegisterType, Long> {
    List<TppRefProductRegisterType> findByProductClassCodeAndAccountType(String productClassCode, String accountType);
}
