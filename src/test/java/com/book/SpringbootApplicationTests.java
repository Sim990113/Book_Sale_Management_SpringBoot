package com.book;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    private BookRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void save(){
        Book book = new Book();
        book.setBook_name("Spring Boot");
        book.setBook_author("张三");
        Book book1 = repository.save(book);
        System.out.println(book1);
    }

    @Test
    void findById(){
        Book book = repository.findById(10001).get();
        System.out.println(book);
    }

    @Test
    void update(){
        Book book = new Book();
        book.setBook_id(12207);
        book.setBook_name("test");
        Book book1 = repository.save(book);
        System.out.println(book1);
    }

    @Test
    void delete(){
        repository.deleteById(12207);
    }
}
