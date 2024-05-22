package org.efub.xclonecoding.post.repository;

import org.efub.xclonecoding.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
