package com.example.springgraphqlpractice.data.repository;

import com.example.springgraphqlpractice.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}