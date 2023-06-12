package com.example.springgraphqlpractice.controllers;

import com.example.springgraphqlpractice.data.entity.Post;
import com.example.springgraphqlpractice.data.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @SchemaMapping(typeName = "Query", value = "allPostsForUser")
    public List<Post> userPosts(@Argument Long userId) {
        return postRepository.findAllByUserId(userId);
    }


    @SchemaMapping(typeName = "Query", value = "findPost")
    public Post findOne(@Argument Long id) {
        return postRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
