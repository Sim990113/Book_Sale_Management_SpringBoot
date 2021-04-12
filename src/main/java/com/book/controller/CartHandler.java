package com.book.controller;

import com.book.entity.Cart;
import com.book.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin //解决跨域问题
@RequestMapping("/cart")
public class CartHandler {
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/findcarts")

    public List<Cart> findCarts(){
        return cartRepository.findAll();
    }

    @Transactional
    @PostMapping("/addcart")
    public String save(@RequestBody Cart cart){
        Cart result = cartRepository.save(cart);
        if(result !=null){
            return "success";
        }else {
            return "error";
        }
    }

    @ResponseBody
    @GetMapping("/findCarts/{userid}")
    public List<Cart> findCarts(@PathVariable("userid") Integer userid){ return cartRepository.findCarts(userid); }

    @ResponseBody
    @GetMapping("/CheckCart/{userid}/{book_id}")
    public List<Cart> CheckCart(@PathVariable("userid") Integer userid, @PathVariable("book_id") Integer book_id){ return cartRepository.CheckCart(userid,book_id); }


    @PutMapping("/AddAmount")
    public String AddAmount(@RequestBody Cart cart){
        Cart result = cartRepository.save(cart);
        if(result !=null){
            return "success";
        }else {
            return "error";
        }
    }

}