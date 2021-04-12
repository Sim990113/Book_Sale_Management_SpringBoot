package com.book.entity;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Cart {
    @Id
    private Integer book_id;
    private Integer userid;
    private String book_name;
    private Integer amount;
    private double price;
    private double sale_price;
    private String img_url;
}