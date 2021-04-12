package com.book.repository;

import com.book.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value="select * from book order by book_id desc limit 4 ;",nativeQuery = true)
    public List<Book> findNewBooks();

    @Query(value="select * from book where right(book_id,1) = ?1 limit 4;",nativeQuery = true)
    public List<Book> findDayBooks(Integer day);

    @Query(value="select * from book where right(book_id,1) = ?1 ;",nativeQuery = true)
    public List<Book> findDayDiscountBooks(Integer day);

    @Query(value="select * from book order by price limit 4;",nativeQuery = true)
    public List<Book> findLowPrice();

    @Query(value="select  * from book order by pages/price desc limit 4;",nativeQuery = true)
    public List<Book> findHighBooks();

    @Query(value="select * from book order by publish_date desc limit 1000; ",nativeQuery = true)
    public List<Book> findHotBooks();

    @Query(value="select * from book where book_type = 'F 经济' order by publish_date desc limit 5 ; ",nativeQuery = true)
    public List<Book> findEconomicHotBook();

    @Query(value="select * from book where book_type = 'I 文学' order by publish_date desc limit 5 ; ",nativeQuery = true)
    public List<Book> findLiteratureHotBook();

    @Query(value="select * from book where book_type = 'J 艺术' order by publish_date desc limit 5 ; ",nativeQuery = true)
    public List<Book> findArtHotBook();

    @Query(value="select * from book where book_type = 'K 历史' order by publish_date desc limit 5 ; ",nativeQuery = true)
    public List<Book> findHistoricHotBook();

    @Query(value="select * from book where book_type = ?1 limit 5;",nativeQuery = true)
    public List<Book> findByType_5(String book_type);

    @Query(value="select * from book where book_type = ?1 ;",nativeQuery = true)
    public List<Book> findByType(String book_type);

    @Query(value="select * from book where book_name like concat('%',:name,'%') or book_author like concat('%',:name,'%') or publishing_house like concat('%',:name,'%');",nativeQuery = true)
    public List<Book> searchByAll(String name);

    @Query(value="select * from book where book_author like concat('%',:name,'%'); ",nativeQuery = true)
    public List<Book> searchByAuthor(String name);

    @Query(value="select * from book where book_name like concat('%',:book_name,'%'); ",nativeQuery = true)
    public List<Book> searchByName(String book_name);

    @Query(value="select * from book where publishing_house like concat('%',:name,'%'); ",nativeQuery = true)
    public List<Book> searchByPublish(String name);




}
