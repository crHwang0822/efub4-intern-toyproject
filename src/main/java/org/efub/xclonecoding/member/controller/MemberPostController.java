package org.efub.xclonecoding.member.controller;

import lombok.RequiredArgsConstructor;
import org.efub.xclonecoding.member.domain.Member;
import org.efub.xclonecoding.member.service.MemberService;
import org.efub.xclonecoding.post.dto.PostListDto;
import org.efub.xclonecoding.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members/{memberId}/posts")
public class MemberPostController {

    private final MemberService memberService;
    private final PostService postService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PostListDto getMemberPost(@PathVariable("memberId") final Long memberId){
        Member member = memberService.findMemberById(memberId);
        PostListDto postList = postService.getPostByMember(member);
        return postList;
    }
}
