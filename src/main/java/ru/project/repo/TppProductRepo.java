package ru.project.repo;


import org.springframework.data.repository.CrudRepository;
import ru.project.model.TppProduct;

import java.util.List;

public interface TppProductRepo extends CrudRepository<TppProduct, Long> {
    List<TppProduct> findByNumber(String number);
}
