package com.example.springgraphqlpractice.service;

import com.example.springgraphqlpractice.data.entity.User;
import com.example.springgraphqlpractice.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<User> getUsers() {
    return userRepository.findAll();
  }
}
