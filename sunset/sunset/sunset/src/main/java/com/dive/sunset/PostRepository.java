package com.dive.sunset;

public interface PostRepository extends org.springframework.data.jpa.repository.JpaRepository<PostEntity, Long> {
    PostEntity findByTitle(String Title);
    PostEntity findById(int id);
}