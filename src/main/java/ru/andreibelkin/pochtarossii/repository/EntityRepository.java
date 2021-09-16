package ru.andreibelkin.pochtarossii.repository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface EntityRepository<Entity> {
    Entity save(Entity entity);
    Entity update(Entity entity);
    Optional<Entity> findById(int entityId);
    @Transactional
    void deleteById(Entity entity);
}
