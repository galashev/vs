package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;

@Entity
public class Contract {

    @Id
    @GeneratedValue
    private int idContract;

    private SimpleDateFormat dateContract;

    private int idClient;

    private int idAddress;

    private String comment;

    // данные для расчета премии (может выделить во вложенный класс?)
    private int insuredSum;

    private String dateBeginPeriod; // даты пока возьмем строкой

    private String dateEndPeriod;

    private String typeProperty;  // может Перечислением сделать?

    private String yearConstruction;

    private String squareConstruction;

    // расчетный параметр
    private String insuredBonus;


    public Contract() {
    }


    @JsonProperty("ContractNumber(PK)")
    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    @JsonProperty("DateContract")
    public SimpleDateFormat getDateContract() {
        return dateContract;
    }

    public void setDateContract(SimpleDateFormat dateContract) {
        this.dateContract = dateContract;
    }

    @JsonProperty("IdClient(FK)")
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @JsonProperty("IdAddress(FK)")
    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    @JsonProperty("Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonProperty("InsuredAmount")
    public int getInsuredSum() {
        return insuredSum;
    }

    public void setInsuredSum(int insuredSum) {
        this.insuredSum = insuredSum;
    }

    @JsonProperty("DateBeginPeriod")
    public String getDateBeginPeriod() {
        return dateBeginPeriod;
    }

    public void setDateBeginPeriod(String dateBeginPeriod) {
        this.dateBeginPeriod = dateBeginPeriod;
    }

    @JsonProperty("DateEndPeriod")
    public String getDateEndPeriod() {
        return dateEndPeriod;
    }

    public void setDateEndPeriod(String dateEndPeriod) {
        this.dateEndPeriod = dateEndPeriod;
    }

    @JsonProperty("TypeOfProperty")
    public String getTypeProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    @JsonProperty("YearOfConstruction")
    public String getYearConstruction() {
        return yearConstruction;
    }

    public void setYearConstruction(String yearConstruction) {
        this.yearConstruction = yearConstruction;
    }

    @JsonProperty("SquareOfConstruction")
    public String getSquareConstruction() {
        return squareConstruction;
    }

    public void setSquareConstruction(String squareConstruction) {
        this.squareConstruction = squareConstruction;
    }

    @JsonProperty("InsuredBonus")
    public String getInsuredBonus() {
        return insuredBonus;
    }

    public void setInsuredBonus(String insuredBonus) {
        this.insuredBonus = insuredBonus;
    }

}
