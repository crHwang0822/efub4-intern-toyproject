package org.efub.xclonecoding.member.service;

import lombok.RequiredArgsConstructor;
import org.efub.xclonecoding.member.domain.Member;
import org.efub.xclonecoding.member.dto.MemberProfileResponse;
import org.efub.xclonecoding.member.dto.SignupRequestDto;
import org.efub.xclonecoding.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    public Long signup(SignupRequestDto requestDto){
        if(existsByNickname(requestDto.getNickname())){
            throw new IllegalArgumentException("이미 존재하는 닉네임입니다.");
        }
        if(existsByEmail(requestDto.getEmail())){
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        Member member = requestDto.toEntity();
        Long memberId = memberRepository.save(member).getMemberId();

        return memberId;
    }

    public MemberProfileResponse getProfile(Long memberId){
        Member member = findMemberById(memberId);
        return member.toProfileDto();
    }

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email){
        return memberRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public boolean existsByNickname(String nickname){
        return memberRepository.existsByNickname(nickname);
    }

    @Transactional(readOnly = true)
    public Member findMemberById(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(()->{
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        });

        return member;
    }
}
