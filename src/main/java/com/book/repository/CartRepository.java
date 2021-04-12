package com.book.repository;

import com.book.entity.Book;
import com.book.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {


    @Query(value="select * from cart where userid = ?1 ;",nativeQuery = true)
    public List<Cart> findCarts(Integer userid);

    @Query(value="select * from cart where userid = ?1 and book_id = ?2 ;",nativeQuery = true)
    public List<Cart> CheckCart(Integer userid , Integer book_id);



}
