package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DiscussionBoardController {

    private final DiscussionBoard discussionBoard;

    public DiscussionBoardController(DiscussionBoard discussionBoard) {
        this.discussionBoard = discussionBoard;
    }

    // Register a new user
    @PostMapping("/users")
    public String register(@RequestBody UserRequest request) {
        return discussionBoard.registerUser(request.getFullName(), request.getUserName());
    }

    // Create a new post
    @PostMapping("/posts")
    public String createPost(@RequestBody PostRequest request) {
        return discussionBoard.createPost(request.getUserName(), request.getTitle(), request.getBody());
    }

    // Search posts by username
    @GetMapping("/posts")
    public String search(@RequestParam String userName) {
        return discussionBoard.searchPost(userName);
    }
}