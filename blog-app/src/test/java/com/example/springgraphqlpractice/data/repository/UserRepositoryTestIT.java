package com.example.springgraphqlpractice.data.repository;

import com.example.springgraphqlpractice.data.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

class UserRepositoryTestIT extends AbstractRepositoryIT {

  @Autowired
  private UserRepository userRepository;

  @Test
  void shouldReturnAllUsers() {
    var foundUserNames = userRepository
        .findAll()
        .stream()
        .map(User::getName)
        .collect(Collectors.toList());
    Assertions
        .assertThat(foundUserNames)
        .containsExactlyInAnyOrder("John Doe", "Jane Doe");
  }

}


