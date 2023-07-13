package com.dive.sunset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService, PostRepository postRepository) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public String createPost(@RequestParam String title, @RequestParam String content, @RequestParam int password, @RequestParam int condition) {
        postService.createPost(title, content, password, condition);
        return "succeed";
    }

    @GetMapping("/edit")
    public PostEntity editPost(@RequestParam int post_id) {
        return postService.findByPostId(post_id);
    }

    @PutMapping("/edit")
    public String editPost(@RequestParam int post_id, @RequestBody PostEntity post) {
        postService.editPost(post_id, post);
        return "succeed";
    }

    @GetMapping("/lists")
    public Page<String> getPostTitles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return postService.getPostTitles(pageable);
    }
}



