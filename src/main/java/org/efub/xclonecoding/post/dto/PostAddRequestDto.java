package org.efub.xclonecoding.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.efub.xclonecoding.member.domain.Member;
import org.efub.xclonecoding.post.domain.Post;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostAddRequestDto {
    @NotNull
    private Long memberId;
    @NotBlank
    private String content;

    public Post toEntity(Member member){
        return Post.builder()
                .writer(member)
                .content(content)
                .build();
    }
}
