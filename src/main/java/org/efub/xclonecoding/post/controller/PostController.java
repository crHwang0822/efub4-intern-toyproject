package org.efub.xclonecoding.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.efub.xclonecoding.post.dto.PostAddRequestDto;
import org.efub.xclonecoding.post.dto.PostListDto;
import org.efub.xclonecoding.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long addPost(@RequestBody @Valid PostAddRequestDto requestDto){
        return postService.addPost(requestDto);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public String deletePost(@PathVariable("postId") final Long postId){
        postService.deletePost(postId);
        return "트윗을 삭제했습니다.";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PostListDto getAllPost(){
        return postService.getAllPost();
    }
}
