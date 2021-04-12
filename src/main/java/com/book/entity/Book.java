package com.book.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    private String book_name;
    private String book_type;
    private String book_author;
    private String publishing_house;
    private String translator;
    private String publish_date;
    private int pages;
    private double price;
    private double sale_price;
    private String brief_introduction;
    private String author_introduction;
    private String img_url;
}
