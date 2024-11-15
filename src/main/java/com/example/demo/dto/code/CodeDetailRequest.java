package com.example.demo.dto.code;

import com.example.demo.domain.CodeDetail;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CodeDetailRequest {
    private Long codeDetailId; // 코드상세 id pk
    private Long codeId;        // 코드 id fk
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "세부코드는 영어 또는 숫자만 입력할 수 있습니다.")
    private String detailCode; // 세부코드
    @NotBlank
    @Pattern(regexp = "^[가-힣0-9\\s]+$", message = "한글, 숫자, 공백만 입력할 수 있습니다.")
    private String codeNameKor; //코드한글명
//    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "영어, 숫자, 공백만 입력할 수 있습니다.")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "영어, 숫자, 공백만 입력할 수 있습니다.") // * 표시가 null 허용? 인듯
    private String codeNameEng; //코드영문명
    private String codeOther; //코드기타명
    private Boolean isActive; // 사용여부
    private Long displayOrder; //표시순서

    public CodeDetail toEntity() {
        return CodeDetail.builder()
                .codeDetailId(this.codeDetailId)
                .codeId(this.codeId)
                .detailCode(this.detailCode)
                .codeNameKor(this.codeNameKor)
                .codeNameEng(this.codeNameEng)
                .codeOther(this.codeOther)
                .isActive(this.isActive)
                .displayOrder(this.displayOrder)
                .build();
    }
}
