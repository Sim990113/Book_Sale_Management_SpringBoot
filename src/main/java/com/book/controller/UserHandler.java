package com.book.controller;

import com.book.entity.Book;
import com.book.entity.User;
import com.book.repository.UserRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin //解决跨域问题
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findById/{userid}")
    public User findById(@PathVariable("userid")Integer userid){
        return userRepository.findById(userid).get();
    }

    @GetMapping("/findByIdnum/{idnum}")
    public User exists(@PathVariable("idnum")String idnum){
        return userRepository.findByIdnum(idnum);
    }

    @PostMapping("/adduser")
    public String save(@RequestBody User user){
        User result = userRepository.save(user);
        if(result !=null){
            return "success";
        }else {
            return "error";
        }
    }

    @PutMapping("/forget")
    public String update(@RequestBody User user){
        User result = userRepository.save(user);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @PutMapping("/update")
    public String updateuser(@RequestBody User user){
        User result = userRepository.save(user);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

}
