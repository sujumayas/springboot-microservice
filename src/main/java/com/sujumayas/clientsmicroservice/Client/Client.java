package com.sujumayas.clientsmicroservice.client;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Client base Model
 */
@Entity
public class Client {

    @Id
    private String id;
    private String name;
    private String lastName;
    private String age;
    private String birthDate;

    /** Needed for future microservices RestTemplate implementation */
    public Client(){ 
    }

    /** Main Constructor */
    public Client(String id, String name, String lastName, String age, String birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    
}