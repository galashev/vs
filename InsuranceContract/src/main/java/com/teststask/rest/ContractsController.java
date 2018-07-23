package com.teststask.rest;

import com.teststask.model.Contract;
import com.teststask.repository.ContractsRepository;
import com.teststask.service.ContractsProcessing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ContractsController {

    private ContractsRepository repository;

    public ContractsController(ContractsRepository repository) {
        this.repository = repository;
        Contract contract = new Contract();

        // параметры пока на гвоздях
        contract.setComment("John's flat");
        contract.setInsuredSum(29000);
        contract.setDateBeginPeriod("01.08.2018");
        contract.setDateEndPeriod("31.08.2018");
        contract.setTypeProperty("Квартира");
        contract.setYearProperty("Меньше 2000");
        contract.setSquareProperty("55");
        contract.setInsuredBonus(ContractsProcessing.CalcInsuredBonus(contract));

        repository.save(contract);
    }

    @GetMapping("/contracts")
    public List<Contract> allContracts() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    /**
     * Информационный метод, позволяющий быстро проверить работоспособность сервиса
     * и способность обрабатывать пользовательские запросы.
     *
     * @return
     */
    @GetMapping("/info")
    public String getInfo() {
        return "Всё работает замечательно!";
    }

}
