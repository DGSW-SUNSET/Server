package com.dive.sunset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public PostEntity createPost(@RequestParam(required = false) String title, @RequestParam(required = false) String content) {
        return postService.createPost(title, content);
    }


}



