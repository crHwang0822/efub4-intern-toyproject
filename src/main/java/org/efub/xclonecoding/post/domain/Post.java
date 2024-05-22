package org.efub.xclonecoding.post.domain;

import jakarta.persistence.*;
import lombok.*;
import org.efub.xclonecoding.global.entity.BaseTimeEntity;
import org.efub.xclonecoding.member.domain.Member;
import org.efub.xclonecoding.post.dto.SinglePostDto;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", updatable = false)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", updatable = false)
    private Member writer;

    @Column(length = 140)
    private String content;


    public SinglePostDto toSigleDto(){
        return SinglePostDto.builder()
                .postId(this.postId)
                .writerName(this.writer.getName())
                .writerNickname(this.writer.getNickname())
                .content(this.content)
                .regDate(this.getRegDate())
                .build();
    }

}
