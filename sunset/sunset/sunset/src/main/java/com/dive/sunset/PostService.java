package com.dive.sunset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(String title, String content, int password, int condition) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(title);
        postEntity.setContent(content);
        postEntity.setPassword(password);
        postEntity.setCondition(condition);
        postRepository.save(postEntity);
    }

    public PostEntity findByPostId(int post_id) {
        return postRepository.findById(post_id);
    }

    public void editPost(int postId, PostEntity post) {
        PostEntity postEntity = postRepository.findById(postId);
        postEntity.setTitle(post.getTitle());
        postEntity.setContent(post.getContent());
        postEntity.setPassword(post.getPassword());
        postEntity.setCondition(post.getCondition());
        postRepository.save(postEntity);
    }

    public Page<String> getPostTitles(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(PostEntity::getTitle);
    }
}
