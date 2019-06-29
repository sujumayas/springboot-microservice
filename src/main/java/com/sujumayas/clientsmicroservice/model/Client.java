package com.sujumayas.clientsmicroservice.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Client base Model
 */
@Entity
@Table(name = "clients")
public class Client {

    @Id
    private long id;
    
    private String name;
    private String lastName;
    private String age;
    private String birthDate;

    /** Needed for future microservices RestTemplate implementation */
    public Client(){ 
    }

    /** Main Constructor */
    public Client(String name, String lastName, String age, String birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age", nullable = false)
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Column(name = "birth_date", nullable = false)
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString(){
        return "Cliente: { id: "+ id + ", Name: "+ name +", LastName: "+lastName+", Age: "+age+", BirthDate: "+birthDate+" }"; 

    }

    
}