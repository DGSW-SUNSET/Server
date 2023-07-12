package com.dive.sunset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity createPost(String title, String content) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(title);
        postEntity.setContent(content);

        return postRepository.save(postEntity);
    }
}
