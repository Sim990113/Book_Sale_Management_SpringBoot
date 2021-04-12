package com.book.repository;

import com.book.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    Manager findByIdnum(String Idnum);
}
