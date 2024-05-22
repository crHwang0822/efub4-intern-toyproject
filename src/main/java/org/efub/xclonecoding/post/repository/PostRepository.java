package org.efub.xclonecoding.post.repository;

import org.efub.xclonecoding.member.domain.Member;
import org.efub.xclonecoding.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByWriter(Member member);
}
