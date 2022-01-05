package com.example.H2Fullstack.Entity;

import javax.persistence.*;

@Entity
@Table(name = "beverages")
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "beverage")
    private String beverageName;

    @Column(name = "cheese1")
    private String cheese1Name;

    @Column(name = "cheese2")
    private String cheese2Name;

    @Column(name = "cheese3")
    private String cheese3Name;

    @Column(name = "cheese4")
    private String cheese4Name;

    @Column(name = "cheese5")
    private String cheese5Name;

    public Beverage() {
    }

    public Beverage(long id, String beverageName, String cheese1Name, String cheese2Name, String cheese3Name, String cheese4Name, String cheese5Name) {
        this.id = id;
        this.beverageName = beverageName;
        this.cheese1Name = cheese1Name;
        this.cheese2Name = cheese2Name;
        this.cheese3Name = cheese3Name;
        this.cheese4Name = cheese4Name;
        this.cheese5Name = cheese5Name;
    }

    public long getId() {
        return id;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public String getCheese1Name() {
        return cheese1Name;
    }

    public void setCheese1Name(String cheese1Name) {
        this.cheese1Name = cheese1Name;
    }

    public String getCheese2Name() {
        return cheese2Name;
    }

    public void setCheese2Name(String cheese2Name) {
        this.cheese2Name = cheese2Name;
    }

    public String getCheese3Name() {
        return cheese3Name;
    }

    public void setCheese3Name(String cheese3Name) {
        this.cheese3Name = cheese3Name;
    }

    public String getCheese4Name() {
        return cheese4Name;
    }

    public void setCheese4Name(String cheese4Name) {
        this.cheese4Name = cheese4Name;
    }

    public String getCheese5Name() {
        return cheese5Name;
    }

    public void setCheese5Name(String cheese5Name) {
        this.cheese5Name = cheese5Name;
    }
}