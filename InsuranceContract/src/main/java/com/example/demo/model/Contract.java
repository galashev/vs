package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Contract {

    @Id
    @GeneratedValue
    private int idContract;

    private Date dateContract;

    private int idClient;

    private int idAddress;

    private String comment;

    // данные для расчета премии (может выделить во вложенный класс?)
    private int insuredSum;

    private Date dateBeginPeriod;

    private Date dateEndPeriod;

//    private List<String> typeProperty;  // может Перечислением сделать?

    private String yearConstruction;

    private String squareConstruction;


    public Contract() {
    }


    @JsonProperty("ContractNumber")
    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    @JsonProperty("DateContract")
    public Date getDateContract() {
        return dateContract;
    }

    public void setDateContract(Date dateContract) {
        this.dateContract = dateContract;
    }

    @JsonProperty("IdClient")
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @JsonProperty("IdAddress")
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
    public Date getDateBeginPeriod() {
        return dateBeginPeriod;
    }

    public void setDateBeginPeriod(Date dateBeginPeriod) {
        this.dateBeginPeriod = dateBeginPeriod;
    }

    @JsonProperty("DateEndPeriod")
    public Date getDateEndPeriod() {
        return dateEndPeriod;
    }

    public void setDateEndPeriod(Date dateEndPeriod) {
        this.dateEndPeriod = dateEndPeriod;
    }

//    @JsonProperty("TypeOfProperty")
//    public List<String> getTypeProperty() {
//        return typeProperty;
//    }
//
//    public void setTypeProperty(List<String> typeProperty) {
//        this.typeProperty = typeProperty;
//    }

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

}
