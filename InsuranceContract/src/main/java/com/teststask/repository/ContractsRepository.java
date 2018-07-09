package com.teststask.repository;

import com.teststask.model.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractsRepository extends CrudRepository<Contract, Integer> {
    List<Contract> findAll();
    List<Contract> findById(int id);
}
