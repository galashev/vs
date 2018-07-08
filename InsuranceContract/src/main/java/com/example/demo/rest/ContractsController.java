package com.example.demo.rest;

import com.example.demo.model.Contract;
import com.example.demo.repository.ContractsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ContractsController {

    private ContractsRepository repository;

    private static final int CAST_TO_DAYS = 1000 * 60 * 60 * 24;

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
        contract.setInsuredBonus(CalcInsuredBonus(contract));

        repository.save(contract);
    }


    private String CalcInsuredBonus(Contract contract) {
        double bonus;

        // расчет страхового периода
        int diffInDays = (int)( (ConvertFormat(contract.getDateEndPeriod()).getTime() -
                                    ConvertFormat(contract.getDateBeginPeriod()).getTime()) / CAST_TO_DAYS );

        // расчет страховой премии
        bonus = ( contract.getInsuredSum() / diffInDays ) * Double.valueOf(contract.getTypeProperty())
                                                            * Double.valueOf(contract.getYearConstruction())
                                                            * Double.valueOf(contract.getSquareConstruction());

        return new DecimalFormat("##.00").format(bonus);
    }

    /*
     * пока Дату читаем строкой, надо ее преобразовать
     */
    private Date ConvertFormat(String stringToDate) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(stringToDate);
        } catch (ParseException e) {
            System.out.println("Не смог распарсить " + stringToDate);
        }
        return new Date();
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
