package org.efub.xclonecoding.post.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
public class PostListDto {
    private List<SinglePostDto> posts;
    private Long count;
}
