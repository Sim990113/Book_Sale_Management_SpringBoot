package com.book.repository;

import com.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByIdnum(String Idnum);
}
