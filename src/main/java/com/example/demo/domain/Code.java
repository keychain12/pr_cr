package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Code {

    private Long codeId; // id값
    private String code;  // 코드
    private String codeCategoryName; //코드분류명
    private String codeDescription; // 코드설명
    private Boolean isStandardCode; // 표준부호여부
    private Boolean isActive;          // 사용여부

    @Builder
    public Code(Long codeId, String code, String codeCategoryName, String codeDescription, Boolean isStandardCode, Boolean isActive) {
        this.codeId = codeId;
        this.code = code;
        this.codeCategoryName = codeCategoryName;
        this.codeDescription = codeDescription;
        this.isStandardCode = isStandardCode;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Code{" +
                "codeId=" + codeId +
                ", code='" + code + '\'' +
                ", codeCategoryName='" + codeCategoryName + '\'' +
                ", codeDescription='" + codeDescription + '\'' +
                ", isStandardCode=" + isStandardCode +
                ", isActive=" + isActive +
                '}';
    }
}
