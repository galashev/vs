package com.teststask.service;


import com.teststask.model.Contract;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ContractsProcessing {
    private static final int CAST_TO_DAYS = 1000 * 60 * 60 * 24;

    public static String CalcInsuredBonus(Contract contract) {
        double bonus;

        // расчет страхового периода
        int diffInDays = (int)( (ConvertFormat(contract.getDateEndPeriod()).getTime() -
                ConvertFormat(contract.getDateBeginPeriod()).getTime()) / CAST_TO_DAYS );

        // расчет страховой премии
        bonus = ( contract.getInsuredSum() / diffInDays )
                * Double.valueOf(contract.getTypeProperty())
                * Double.valueOf(contract.getYearConstruction())
                * Double.valueOf(contract.getSquareConstruction());

        return new DecimalFormat("##.00").format(bonus);
    }

    /*
     * пока Дату читаем строкой, надо ее преобразовать
     */
    private static Date ConvertFormat(String stringToDate) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(stringToDate);
        } catch (ParseException e) {
            System.out.println("Не смог распарсить " + stringToDate);
        }
        return new Date();  // TODO:
    }
}
