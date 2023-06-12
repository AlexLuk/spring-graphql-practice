package com.example.springgraphqlpractice.data.repository;

import com.example.springgraphqlpractice.data.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserId(Long userId);

}