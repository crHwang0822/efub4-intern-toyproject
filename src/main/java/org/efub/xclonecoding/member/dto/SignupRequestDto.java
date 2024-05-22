package org.efub.xclonecoding.member.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.efub.xclonecoding.member.domain.Member;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class SignupRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String nickname;
    @Email
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!.?,])[A-Za-z\\d!.?,]{2,16}$",
            message = "16자 이내의 영문자 및 숫자와 ?,!,., , 특수문자로 입력해주세요.")
    private String password;

    public Member toEntity(){
        return Member.builder()
                .name(this.name)
                .nickname(this.nickname)
                .email(this.email)
                .birthday(this.birthday)
                .password(this.password)
                .build();
    }
}
