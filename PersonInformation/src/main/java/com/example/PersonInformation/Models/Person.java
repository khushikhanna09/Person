package com.example.PersonInformation.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue()
    private int id;

    @Column(
            nullable = false
    )
    public String firstname;

    @Column(
            nullable = false
    )
    public String lastname;

    @Column(
            nullable = false
    )
    public Integer age;

    @Column(
            nullable = false
    )
    public String occupation;

    @Column(
            nullable = false,
            unique = true

    )
    public Integer ssnnum;

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public long getSsnnum() {
        return ssnnum;
    }

    public void setSsnnum(Integer ssnnum) {
        this.ssnnum = ssnnum;
    }

    public Person(String firstname, String lastname, Integer age, String occupation,Integer ssnnum){
        this.firstname=firstname;
        this.lastname=lastname;
        this.age=age;
        this.occupation=occupation;
        this.ssnnum=ssnnum;
    }

    public int getAge() {
        return age;
    }

}

