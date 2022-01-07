package com.example.H2Fullstack.Entity;

import javax.persistence.*;

@Entity
@Table(name = "beverages")
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "beverage_name")
    private String beverage_name;

    @Column(name = "cheese1_name")
    private String cheese1_name;

    @Column(name = "cheese2_name")
    private String cheese2_name;

    @Column(name = "cheese3_name")
    private String cheese3_name;

    @Column(name = "cheese4_name")
    private String cheese4_name;

    @Column(name = "cheese5_name")
    private String cheese5_name;

    public Beverage() {
    }

    public Beverage(long id, String beverage_name, String cheese1_name, String cheese2_name, String cheese3_name, String cheese4_name, String cheese5_name) {
        this.id = id;
        this.beverage_name = beverage_name;
        this.cheese1_name = cheese1_name;
        this.cheese2_name = cheese2_name;
        this.cheese3_name = cheese3_name;
        this.cheese4_name = cheese4_name;
        this.cheese5_name = cheese5_name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getBeverageName() {
        return beverage_name;
    }

    public void setBeverageName(String beverageName) {
        this.beverage_name = beverage_name;
    }

    public String getCheese1Name() {
        return cheese1_name;
    }

    public void setCheese1Name(String cheese1_name) {
        this.cheese1_name = cheese1_name;
    }

    public String getCheese2Name() {
        return cheese2_name;
    }

    public void setCheese2Name(String cheese2_name) {
        this.cheese2_name = cheese2_name;
    }

    public String getCheese3Name() {
        return cheese3_name;
    }

    public void setCheese3Name(String cheese3_name) {
        this.cheese3_name = cheese3_name;
    }

    public String getCheese4Name() {
        return cheese4_name;
    }

    public void setCheese4Name(String cheese4_name) {
        this.cheese4_name = cheese4_name;
    }

    public String getCheese5Name() {
        return cheese5_name;
    }

    public void setCheese5Name(String cheese5_name) {
        this.cheese5_name = cheese5_name;
    }
}