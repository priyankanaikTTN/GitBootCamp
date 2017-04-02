package com.hibernate.demo;

import javax.persistence.*;
import java.util.*;

/**
 * Created by priyanka on 25/3/17.
 */
@Entity
public class Author {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

   @Column(name="Fname")
    String firstname;

   @Column(name="Lname")
   @Transient
    String lastname;

   @Column(name="Age")
    int age;

    @Temporal(TemporalType.DATE)
    Date dob;

    @ElementCollection
    List<String> subject=new ArrayList<>();

    @Embedded
    Address address;

    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Book> books= new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }












    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }




    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
