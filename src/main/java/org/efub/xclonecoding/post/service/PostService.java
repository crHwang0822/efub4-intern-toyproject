package org.efub.xclonecoding.post.service;

import lombok.RequiredArgsConstructor;
import org.efub.xclonecoding.member.domain.Member;
import org.efub.xclonecoding.member.service.MemberService;
import org.efub.xclonecoding.post.domain.Post;
import org.efub.xclonecoding.post.dto.PostAddRequestDto;
import org.efub.xclonecoding.post.dto.PostListDto;
import org.efub.xclonecoding.post.dto.SinglePostDto;
import org.efub.xclonecoding.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public void deletePost(Long postId){
        Post post = findPostById(postId);
        postRepository.delete(post);
    }

    public PostListDto getAllPost(){
        List<Post> posts = postRepository.findAll();
        List<SinglePostDto> postDtos = posts.stream().map(post->post.toSigleDto()).collect(Collectors.toList());
        PostListDto postListDto = PostListDto.builder()
                .posts(postDtos)
                .count((long) postDtos.size())
                .build();
        return postListDto;
    }

    public SinglePostDto getPost(Long postId){
        Post post = findPostById(postId);
        SinglePostDto postDto = post.toSigleDto();
        return postDto;
    }

    public PostListDto getPostByMember(Member member){
        List<Post> posts = postRepository.findAllByWriter(member);
        List<SinglePostDto> postDtos = posts.stream().map(post->post.toSigleDto()).collect(Collectors.toList());
        PostListDto postListDto = PostListDto.builder()
                .posts(postDtos)
                .count((long) postDtos.size())
                .build();
        return postListDto;
    }

    @Transactional(readOnly = true)
    public Post findPostById(Long postId){
        Post post = postRepository.findById(postId).orElseThrow((()->{
            throw new IllegalArgumentException("존재하지 않는 트윗입니다.");
        }));
        return post;
    }

}
