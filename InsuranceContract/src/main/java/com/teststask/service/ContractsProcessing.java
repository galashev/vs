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
        double rateTypeProperty, rateYearProperty, rateSquareProperty;

        // формула расчета страхового периода
        int diffInDays = (int) ((ConvertFormat(contract.getDateEndPeriod()).getTime() -
                ConvertFormat(contract.getDateBeginPeriod()).getTime()) / CAST_TO_DAYS);

        // коэффициент за тип недвижимости
        if (contract.getTypeProperty() != null) {
            switch (contract.getTypeProperty()) {
                case "Квартира":
                    rateTypeProperty = 1.7;
                    break;
                case "Дом":
                    rateTypeProperty = 1.5;
                    ;
                    break;
                case "Комната":
                    rateTypeProperty = 1.3;
                    ;
                    break;
                default:
                    rateTypeProperty = 0;
                    //System.out.println("Для расчета премии определите тип недвижимости.");
            }
        } else {
            rateTypeProperty = 0;
            //System.out.println("Для расчета премии определите тип недвижимости.");
        }

        // коэффициент за год постройки
        if (contract.getYearProperty() != null) {
            switch (contract.getYearProperty()) {
                case "Меньше 2000":
                    rateYearProperty = 1.3;
                    break;
                case "2000 - 2014":
                    rateYearProperty = 1.6;
                    ;
                    break;
                case "2015":
                    rateYearProperty = 2;
                    ;
                    break;
                default:
                    rateYearProperty = 0;
                    //System.out.println("Для расчета премии определите год недвижимости.");
            }
        } else {
            rateYearProperty = 0;
            //System.out.println("Для расчета премии определите год недвижимости.");
        }

        // коэффициент за площадь
        if(contract.getSquareProperty() != null) {
            double squareProperty = Double.valueOf(contract.getSquareProperty());
            if (squareProperty < 50) {
                rateSquareProperty = 1.2;
            } else if (squareProperty > 100) {
                rateSquareProperty = 2;
            } else {
                rateSquareProperty = 1.5;
            }
        } else {
            rateSquareProperty = 0;
            //System.out.println("Для расчета премии определите площадь недвижимости.");
        }

        // формула расчета страховой премии
        bonus = ( contract.getInsuredSum() / diffInDays ) * rateTypeProperty
                                                            * rateYearProperty * rateSquareProperty;

        return new DecimalFormat("##.00").format(bonus);
    }

    /**
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
