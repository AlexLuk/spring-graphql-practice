package com.example.springgraphqlpractice.controllers;

import com.example.springgraphqlpractice.data.entity.User;
import com.example.springgraphqlpractice.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @QueryMapping
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @QueryMapping
    public Optional<User> findUser(@Argument Long id) {
        return userRepository.findById(id);
    }

}
