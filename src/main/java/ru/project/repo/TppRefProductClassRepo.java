package ru.project.repo;

import org.springframework.data.repository.CrudRepository;
import ru.project.model.TppRefProductClass;

import java.util.Optional;

public interface TppRefProductClassRepo extends CrudRepository<TppRefProductClass, Long> {
    Optional<TppRefProductClass> findByValue(String value);
}
