package com.teststask.repository;

import com.teststask.model.Contract;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Базовый CRUD-репозиторий. Поддерживает кэширование загружаемых объектов.
 *
 * Cacheable, CachePut и CacheEvict являются аннотациями,
 *  которыми управляет post processor (описан в классе Application).
 * Более подробную информацию смотрите в документации.
 */
public interface CachedRepository extends CrudRepository<Contract, Integer> {

    @Cacheable("contracts")
    List<Contract> findById(int id);

//    @Cacheable("contracts")
//    List<Contract> findByName(String name);
}
