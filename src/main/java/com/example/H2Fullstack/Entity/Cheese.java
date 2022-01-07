package com.example.H2Fullstack.Entity;

import javax.persistence.*;

@Entity
@Table(name = "cheeses")
public class Cheese {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "cheese")
    private String cheese_name;

    @Column(name = "beverage1")
    private String beverage1_name;

    @Column(name = "beverage2")
    private String beverage2_name;

    @Column(name = "beverage3")
    private String beverage3_name;

    @Column(name = "beverage4")
    private String beverage4_name;

    @Column(name = "beverage5")
    private String beverage5_name;

    @Column(name = "beverage6")
    private String beverage6_name;

    @Column(name = "beverage7")
    private String beverage7_name;

    @Column(name = "origin")
    private String country_of_origin;

    @Column(name = "aging_period")
    private String aging_period;

    @Column(name = "milk_type")
    private String type_of_milk;

    @Column(name = "taste")
    private String taste;

    @Column(name = "best_uses")
    private String best_uses;

    @Column(name = "notes")
    private String notes;

    @Column(name = "image")
    private String image;


    public Cheese(long id, String cheese_name, String beverage1_name, String beverage2_name, String beverage3_name, String beverage4_name, String beverage5_name, String beverage6_name, String beverage7_name, String country_of_origin, String type_of_milk, String aging_period,  String taste, String best_uses, String notes) {
        this.id = id;
        this.cheese_name = cheese_name;
        this.beverage1_name = beverage1_name;
        this.beverage2_name = beverage2_name;
        this.beverage3_name = beverage3_name;
        this.beverage4_name = beverage4_name;
        this.beverage5_name = beverage5_name;
        this.beverage6_name = beverage6_name;
        this.beverage7_name = beverage7_name;
        this.country_of_origin = country_of_origin;
        this.aging_period = aging_period;
        this.type_of_milk = type_of_milk;
        this.taste = taste;
        this.best_uses = best_uses;
        this.notes = notes;
    }

    public Cheese(){}

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getCheeseName() {
        return cheese_name;
    }

    public void setCheeseName(String cheeseName) {
        this.cheese_name = cheese_name;
    }

    public String getBeverage1Name() {
        return beverage1_name;
    }

    public void setBeverage1Name(String beverage1Name) {
        this.beverage1_name = beverage1_name;
    }

    public String getBeverage2Name() {
        return beverage2_name;
    }

    public void setBeverage2Name(String beverage2Name) {
        this.beverage2_name = beverage2_name;
    }

    public String getBeverage3Name() {
        return beverage3_name;
    }

    public void setBeverage3Name(String beverage3Name) {
        this.beverage3_name = beverage3_name;
    }

    public String getBeverage4Name() {
        return beverage4_name;
    }

    public void setBeverage4Name(String beverage4Name) {
        this.beverage4_name = beverage4_name;
    }

    public String getBeverage5Name() {
        return beverage5_name;
    }

    public void setBeverage5Name(String beverage5Name) {
        this.beverage5_name = beverage5_name;
    }

    public String getBeverage6Name() {
        return beverage5_name;
    }

    public void setBeverage6Name(String beverage6Name) {
        this.beverage6_name = beverage6_name;
    }

    public String getBeverage7Name() {
        return beverage7_name;
    }

    public void setBeverage7Name(String beverage7Name) {
        this.beverage7_name = beverage7_name;
    }

    public String getCountryOfOrigin() {
        return country_of_origin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.country_of_origin = country_of_origin;
    }

    public String getAgingPeriod() {
        return aging_period;
    }

    public void setAgingPeriod(String agingPeriod) {
        this.aging_period = aging_period;
    }

    public String getTypeOfMilk() {
        return type_of_milk;
    }

    public void setTypeOfMilk(String typeOfMilk) {
        type_of_milk = type_of_milk;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getBestUses() {
        return best_uses;
    }

    public void setBestUses(String bestUses) {
        this.best_uses = best_uses;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}