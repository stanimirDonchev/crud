/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Stanimir Donchev
 */
@Entity
public class Human 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String dob;
    private String phoneNumber;
    private String email;

    public Human() 
    {
    }

    public Human(String firstName, String lastName, String dob, String phoneNumber, String email)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDob(dob);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
    }

    public Human(long id, String firstName, String lastName, String dob, String phoneNumber, String email) 
    {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDob(dob);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
