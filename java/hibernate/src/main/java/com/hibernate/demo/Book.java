package com.hibernate.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by priyanka on 26/3/17.
 */
@Entity
public class Book {



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   int  bookId;
    String bookName;


    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @ManyToMany(mappedBy = "books")
    List<Author> authorList = new ArrayList<Author>();


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }



}

