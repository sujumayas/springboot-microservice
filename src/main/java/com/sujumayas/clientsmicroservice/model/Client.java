package com.sujumayas.clientsmicroservice.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Client base Model
 */
@Entity
@Table(name = "clients")
@ApiModel(description = "All details about the Client. ")
public class Client {

    @ApiModelProperty(notes = "The database generated Client ID")
    private Long id;
    
    @ApiModelProperty(notes = "The Clients Name")
    private String name;
    
    @ApiModelProperty(notes = "The Clients LastName")
    private String lastName;
    
    @ApiModelProperty(notes = "The Clients Age")
    private String age; // Should be birthDate dependant, not user-editable, we are gonna asume users
                        // are honest in their math
    
    @ApiModelProperty(notes = "The Clients Birth Date")    
    private String birthDate;

    @ApiModelProperty(notes = "We all know this parameter should be global... but it does not matter because this has no getter <3")
    private Integer LIFE_EXPECTANCY = 75;
    
    @ApiModelProperty(notes = "The aproximate death date (birthDate + LIFE_EXPECTANCY)")
    private String aproxDeathDate;

    /** Needed for future microservices RestTemplate implementation */
    public Client(){ 
    }

    /** Main Constructor */
    public Client(String name, String lastName, String age, String birthDate) {
        
        this.name = name;
        this.lastName = lastName;
        this.age = age; // Should be birthDate dependant, not user-editable, we are gonna asume users are honest in their math
        this.birthDate = birthDate;
        this.aproxDeathDate = this.seTAproxDeathDate(birthDate, this.LIFE_EXPECTANCY);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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