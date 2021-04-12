package com.book.controller;

import com.book.entity.Orders;
import com.book.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin //解决跨域问题
@RequestMapping("/orders")
public class OrderHandler {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/findorders")

    public List<Orders> findOrders(){
        return orderRepository.findAll();
    }

    @Transactional
    @PostMapping("/addorder")
    public String save(@RequestBody Orders order){
        Orders result = orderRepository.save(order);
        if(result !=null){
            return "success";
        }else {
            return "error";
        }
    }

    @ResponseBody
    @GetMapping("/findOrders/{userid}")
    public List<Orders> findOrders(@PathVariable("userid") Integer userid){ return orderRepository.findOrders(userid); }

    @ResponseBody
    @GetMapping("/CheckOrder/{userid}/{book_id}")
    public List<Orders> CheckOrder(@PathVariable("userid") Integer userid, @PathVariable("book_id") Integer book_id){ return orderRepository.CheckOrder(userid,book_id); }


    @PutMapping("/AddAmount")
    public String AddAmount(@RequestBody Orders cart){
        Orders result = orderRepository.save(cart);
        if(result !=null){
            return "success";
        }else {
            return "error";
        }
    }
}