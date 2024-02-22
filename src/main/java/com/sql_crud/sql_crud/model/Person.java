package com.sql_crud.sql_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;

@DataAmount
@Entity
@Table(name = "Students")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String classVlaue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassVlaue() {
        return classVlaue;
    }

    public void setClassVlaue(String classVlaue) {
        this.classVlaue = classVlaue;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person(String name, String classVlaue) {
        this.name = name;
        this.classVlaue = classVlaue;
    }
}
