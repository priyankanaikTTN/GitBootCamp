package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Date;

public class Application {

    public static void main(String[] args) {



        SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();





        Book book1 = new Book();
        book1.setBookName("One Road");



        Book book2 = new Book();
        book2.setBookName("Rich Dad Poor Dad");



        Book book3 = new Book();
        book3.setBookName("Wrong Right");



        Book book4 = new Book();
        book4.setBookName("Back in 90s");

        Book book5 = new Book();
        book5.setBookName("Love by chance");

        Book book6 = new Book();
        book6.setBookName("Dark");

                Book book7 = new Book();
        book7.setBookName("Lost");


        Book book8 = new Book();
        book8.setBookName("Shared1");


        Book book9 = new Book();
        book9.setBookName("Shared2");


        // **********************Author first************************

        Address address1=new Address();
        address1.setState("Delhi");
        address1.setLocation("Delhi");
        address1.setStreetNumber("10");



       Author a = new Author();
       a.setAge(23);
       a.setFirstname("Diksha");
       a.setLastname("Negi");
       a.setDob(new Date("1993/07/12"));
       a.setAddress(address1);

       book1.getAuthorList().add(a);
        book2.getAuthorList().add(a);

        a.getBooks().add(book1);
        a.getBooks().add(book2);

       a.setSubject(Arrays.asList("Fiction","Thriller","Science"));

        session.persist(a);

        // ****************************Author second*****************************

        Address address2 = new Address();
        address2.setState("Pune");
        address2.setLocation("Goregaon");
        address2.setStreetNumber("6");



        Author a1 = new Author();

        a1.setAge(40);
        a1.setFirstname("Samay");
        a1.setLastname("Sakshena");
        a1.setDob(new Date("1977/05/27"));
        a1.setAddress(address2);
        book3.getAuthorList().add(a1);

        book4.getAuthorList().add(a1);

        a1.getBooks().add(book3);

        a1.getBooks().add(book4);

        a1.setSubject(Arrays.asList("Romance","Thriller"));

        session.persist(a1);


      //************************* Author third *****************************

        Address address3 = new Address();
        address3.setState("Chennai");
        address3.setLocation("kailash");
        address3.setStreetNumber("10");


        Author a2 = new Author();

        a2.setAge(32);
        a2.setFirstname("Vijay");
        a2.setLastname("Naik");
        a2.setDob(new Date("1985/11/17"));
        a2.setAddress(address3);

        book5.getAuthorList().add(a2);

        book8.getAuthorList().add(a2);

        a2.getBooks().add(book8);

        a2.getBooks().add(book5);

        a2.setSubject(Arrays.asList("Drama","Fiction","Science"));

        session.persist(a2);



       // ******************************* Author fourth*********************

        Address address4 = new Address();
        address4.setState("Noida");
        address4.setLocation("Noida");
        address4.setStreetNumber("5");




        Author a3 = new Author();
        a3.setAge(23);
        a3.setFirstname("Priyanka");
        a3.setLastname("Naik");
        a3.setDob(new Date("1993/07/04"));
        a3.setAddress(address4);

        book6.getAuthorList().add(a3);

        book8.getAuthorList().add(a3);

        a3.getBooks().add(book8);

        a3.getBooks().add(book6);

        a3.setSubject(Arrays.asList("History","Literature"));

        session.persist(a3);



      //***************************** Author fifth******************88

        Address address5 = new Address();
        address5.setState("Pune");
        address5.setLocation("Goregaon");
        address5.setStreetNumber("8");




        Author a4 = new Author();
        a4.setAge(29);
        a4.setFirstname("Akash");
        a4.setLastname("Sakshena");
        a4.setDob(new Date("1988/02/06"));
        a4.setAddress(address5);

        book7.getAuthorList().add(a4);

        book9.getAuthorList().add(a4);

        a4.getBooks().add(book9);

        a4.getBooks().add(book7);

        a4.setSubject(Arrays.asList("Romance","Poetry"));

        session.persist(a4);

        // **************************** Employee first **************************

        Employee e = new Employee();
        e.setName("Suresh Singh");
        session.save(e);


        // ****************************** Employee second ****************88

        Employee e1 = new Employee();
        e1.setName("Ramesh Sinha");
        session.save(e1);




        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        System.out.println("Hello World 1234 !!!!");
    }
}
