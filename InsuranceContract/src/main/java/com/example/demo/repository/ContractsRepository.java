package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Contract;

import java.util.List;

public interface ContractsRepository extends CrudRepository<Contract, Integer> {

    List<Contract> findAll();
//    List<Contract> findByName(String name);

}
