package com.example.demo.dto.code;

import com.example.demo.domain.Code;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CodeRequest {

    private Long codeId;
    @NotNull(message = "코드는 필수입력항목 입니다.\n")
    @Size(min = 1, max = 10, message = "코드는 1자 이상 10자 이하로 입력해야 합니다.\n")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "코드는 영어와 숫자만 입력 가능합니다.\n")
    private String code;  // 코드
    @NotNull(message = "코드분류명은 필수 항목입니다.\n")
    private String codeCategoryName; //코드분류명
    @Size(max = 255, message = "코드설명은 최대 255자까지 입력 가능합니다.\n")
    private String codeDescription; // 코드설명
    private String taskType;    // 업무구분
    private Integer isStandardCode; // 표준부호여부
    private Integer isActive;          // 사용여부


    public Code toEntity() {
        return Code.builder()
                .codeId(this.codeId)
                .code(this.code)
                .codeCategoryName(this.codeCategoryName)
                .codeDescription(this.codeDescription)
                .taskType(this.taskType)
                .isStandardCode(this.isStandardCode)
                .isActive(this.isActive)
                .build();
    }


}
