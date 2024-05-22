package org.efub.xclonecoding.member.domain;

import jakarta.persistence.*;
import lombok.*;
import org.efub.xclonecoding.global.entity.BaseTimeEntity;
import org.efub.xclonecoding.member.dto.MemberProfileResponse;

import java.time.LocalDate;
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", updatable = false)
    private Long memberId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(length = 160)
    private String bio;

    @Column(length = 30)
    private String location;

    public MemberProfileResponse toProfileDto(){
        return MemberProfileResponse.builder()
                .name(this.name)
                .nickname(this.nickname)
                .location(this.location)
                .bio(this.bio)
                .regDate(this.getRegDate())
                .build();
    }

}
