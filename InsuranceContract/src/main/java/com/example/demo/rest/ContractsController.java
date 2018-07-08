package com.example.demo.rest;

import com.example.demo.model.Contract;
import com.example.demo.repository.ContractsRepository;
import com.example.demo.service.ContractProcessing;
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
        contract.setComment("John's house");
        contract.setInsuredSum(25000);
        contract.setDateBeginPeriod("01.08.2018");
        contract.setDateEndPeriod("31.08.2018");
        contract.setTypeProperty("1.5");
        contract.setYearConstruction("1.3");
        contract.setSquareConstruction("2");
        contract.setInsuredBonus(ContractProcessing.CalcInsuredBonus(contract));

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




//    /**
//     * Пример работы с объектами (без ОРМ методологии - возвращает только что созданный объект)
//     * с применением паттерна DAO(DTO).
//     * Старый, не эффективный метод.
//     *
//     * @return
//     */
//    @Deprecated
//    @GetMapping("/contracts_old")
//    public List<ContractDto> allContractsDAO() {
//        return Collections.singletonList(new ContractDto() {{
//            setId("01");
//            setName("Dima");
//        }});
//    }
//
//    @GetMapping("/contract")
//    public List<ContractDto> getContract() {
//        return repository.findAll().stream()
//                .map(contract -> new ContractDto() {{
//                    setId("" + contract.getIdContract());
//                    setName(contract.getComment());
//                }})
//                .collect(Collectors.toList());
//    }
}
