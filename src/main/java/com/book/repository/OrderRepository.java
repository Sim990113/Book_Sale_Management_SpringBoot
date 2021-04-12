package com.book.repository;

import com.book.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {

    @Query(value="select * from orders where userid = ?1 ;",nativeQuery = true)
    public List<Orders> findOrders(Integer userid);

    @Query(value="select * from orders where userid = ?1 and book_id = ?2 ;",nativeQuery = true)
    public List<Orders> CheckOrder(Integer userid , Integer book_id);
}
