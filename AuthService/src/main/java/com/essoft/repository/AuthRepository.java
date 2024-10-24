package com.essoft.repository;

import com.essoft.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Boolean existsByUsernameAndPassword(String username, String password);
}
