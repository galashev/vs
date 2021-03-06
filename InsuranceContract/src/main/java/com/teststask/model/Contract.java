package com.teststask.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Contract {

    @Id
    //@SequenceGenerator(name = "pk_sequence", sequenceName = "contract_id_seq", allocationSize = 1)
    //@Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContract;

    private Date dateContract;

    private int idClient;

    private int idAddress;

    private String comment;

    // вводные для расчета премии
    private int insuredSum;

    private String dateBeginPeriod; // TODO: даты пока возьмем строкой

    private String dateEndPeriod;

    private String typeProperty;  // TODO:

    private String yearProperty;

    private String squareProperty;

    // вычисляемый параметр
    private String insuredBonus;


    public Contract() {}


    @JsonProperty("ContractNumber(PK)")
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

    @JsonProperty("YearOfProperty")
    public String getYearProperty() {
        return yearProperty;
    }

    public void setYearProperty(String yearProperty) {
        this.yearProperty = yearProperty;
    }

    @JsonProperty("SquareOfProperty")
    public String getSquareProperty() {
        return squareProperty;
    }

    public void setSquareProperty(String squareProperty) { this.squareProperty = squareProperty; }

    @JsonProperty("InsuredBonus")
    public String getInsuredBonus() {
        return insuredBonus;
    }

    public void setInsuredBonus(String insuredBonus) {
        this.insuredBonus = insuredBonus;
    }

}
