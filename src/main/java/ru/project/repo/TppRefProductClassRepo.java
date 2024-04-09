package ru.project.repo;

import org.springframework.data.repository.CrudRepository;
import ru.project.model.TppRefProductClass;

public interface TppRefProductClassRepo extends CrudRepository<TppRefProductClass, Long> {
    TppRefProductClass findByValue(String value);
}
