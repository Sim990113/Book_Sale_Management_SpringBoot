package com.book.controller;

import com.book.entity.Manager;
import com.book.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin //解决跨域问题
@RequestMapping("/manager")
public class ManagerHandler {
    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping("/findById/{managerid}")
    public Manager findById(@PathVariable("managerid")Integer manager){
        return managerRepository.findById(manager).get();
    }

    @GetMapping("/findByIdnum/{idnum}")
    public Manager exists(@PathVariable("idnum")String idnum){
        return managerRepository.findByIdnum(idnum);
    }

    @PostMapping("/addmanager")
    public String save(@RequestBody Manager manager){
        Manager result = managerRepository.save(manager);
        if(result !=null){
            return "success";
        }else {
            return "error";
        }
    }

    @PutMapping("/forget")
    public String update(@RequestBody Manager manager){
        Manager result = managerRepository.save(manager);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @PutMapping("/update")
    public String updateuser(@RequestBody Manager manager){
        Manager result = managerRepository.save(manager);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

}
