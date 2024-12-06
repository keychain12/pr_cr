package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Code {

    private String codeId; // 코드
    private String codeCategoryName; //코드분류명
    private String codeDescription; // 코드설명
    private String taskType;    // 업무구분
    private Integer isStandardCode; // 표준부호여부
    private Integer isActive;          // 사용여부

    @Builder
    public Code(String codeId, String codeCategoryName, String codeDescription, String taskType, Integer isStandardCode, Integer isActive) {
        this.codeId = codeId;
        this.codeCategoryName = codeCategoryName;
        this.codeDescription = codeDescription;
        this.taskType = taskType;
        this.isStandardCode = isStandardCode;
        this.isActive = isActive;
    }
}
