package com.example.springgraphqlpractice.data.repository;

import com.example.springgraphqlpractice.data.entity.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

class PostRepositoryTestIT extends AbstractRepositoryIT {

  @Autowired
  private PostRepository postRepository;

  @Test
  void shouldReturnAllPosts() {
    var foundPostTitles = postRepository
        .findAll()
        .stream()
        .map(Post::getTitle)
        .collect(Collectors.toList());
    Assertions
        .assertThat(foundPostTitles)
        .containsExactlyInAnyOrder("My life", "Real story", "Some story", "Real story");
  }

}
