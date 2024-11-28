package com.example.demo.dto.code;

import com.example.demo.domain.CodeDetail;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CodeDetailRequest {
    private Long codeDetailId; // 코드상세 id pk
    private Long codeId;      // 코드 id fk
    @NotBlank(message = "세부코드는 필수 입력항목입니다.\n")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "세부코드는 영어 또는 숫자만 입력할 수 있습니다.\n")
    private String detailCode; // 세부코드
    @NotBlank
    @Pattern(regexp = "^[가-힣0-9\\s]*$", message = "코드한글명은 한글, 숫자, 공백만 입력할 수 있습니다.\n")
    private String codeNameKor; //코드한글명
//    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "영어, 숫자, 공백만 입력할 수 있습니다.")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "코드영문명은 영어, 숫자, 공백만 입력할 수 있습니다.\n") // * 표시가 null 허용? 인듯
    private String codeNameEng; //코드영문명
    private String codeOther; //코드기타명

    private Integer isActive; // 사용여부    boolean 이랑 숫자타입은 NotNull해줘야하는듯 blank 하니까 에러걸림
    @NotNull
    private Long displayOrder; //표시순서
    private String remarks; // 비고
    private String etc1; //기타1
    private String etc2; //기타2
    private String etc3; //기타3
    private String etc4; //기타4


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
                .remarks(this.remarks)
                .etc1(this.etc1)
                .etc2(this.etc2)
                .etc3(this.etc3)
                .etc4(this.etc4)
                .build();
    }
}
