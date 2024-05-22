package org.efub.xclonecoding.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.efub.xclonecoding.member.dto.MemberProfileResponse;
import org.efub.xclonecoding.member.dto.SignupRequestDto;
import org.efub.xclonecoding.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long signup(@RequestBody @Valid SignupRequestDto requestDto){
        return memberService.signup(requestDto);
    }

    @GetMapping("/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public MemberProfileResponse getProfile(@PathVariable("memberId") Long memberId){
        return memberService.getProfile(memberId);
    }
}
