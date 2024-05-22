package org.efub.xclonecoding.post.service;

import lombok.RequiredArgsConstructor;
import org.efub.xclonecoding.member.domain.Member;
import org.efub.xclonecoding.member.service.MemberService;
import org.efub.xclonecoding.post.domain.Post;
import org.efub.xclonecoding.post.dto.PostAddRequestDto;
import org.efub.xclonecoding.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberService memberService;

    public Long addPost(PostAddRequestDto requestDto){
        Member member = memberService.findMemberById(requestDto.getMemberId());
        Post post = requestDto.toEntity(member);
        Long postId = postRepository.save(post).getPostId();
        return postId;
    }

}