package com.example.cryter.repos;

import com.example.cryter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * "Created by : goodlikemax"
 * "Date: "03.12.2019
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
