package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findByEmail(String email);
}



