package com.sujumayas.clientsmicroservice.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Client base Model
 */
@Entity
@Table(name = "clients")
public class Client {

    @Id
    private Long id;
    
    private String name;
    private String lastName;
    private String age; // Should be birthDate dependant, not user-editable, we are gonna asume users
                        // are honest in their math
    private String birthDate;
    private Integer LIFE_EXPECTANCY = 75;
    private String aproxDeathDate;

    /** Needed for future microservices RestTemplate implementation */
    public Client(){ 
    }

    /** Main Constructor */
    public Client(Long id, String name, String lastName, String age, String birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age; // Should be birthDate dependant, not user-editable, we are gonna asume users are honest in their math
        this.birthDate = birthDate;
        this.aproxDeathDate = this.seTAproxDeathDate(birthDate, this.LIFE_EXPECTANCY);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "last_name", nullable = true)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age", nullable = true)
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Column(name = "birth_date", nullable = true)
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "aprox_death_date", nullable = true)
    public String getAproxDeathDate(){
        return aproxDeathDate;
    }

    public void setAproxDeathDate(String aproxDeathDate){
        this.aproxDeathDate = aproxDeathDate;
    }

    /**
     * Set Aprox Death Date for this human. 
     * 
     * Every Human must die. Machines will prevail. 
     * 
     * TODO: Should refactor this to static class of Utils and call it from there. 
     * 
     * @param birthDateString
     * @param yearsToLive
     * @param age
     * @return
     */
    private String seTAproxDeathDate(String birthDateString, Integer yearsToLive){
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        
        LocalDate dateTime = LocalDate.parse(birthDateString, formatter);
        
        dateTime = dateTime.plusYears(yearsToLive);
        
        String aproxDeathDate = dateTime.format(formatter);
        
        return aproxDeathDate;
        
    }



    @Override
    public String toString(){
        return "Cliente: { id: " + id + ", Name: " + name + ", LastName: " + lastName + ", Age: " + age + ", BirthDate: " + birthDate + " }"; 
    }

    
}