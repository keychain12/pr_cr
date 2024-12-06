package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CodeDetail {
    private String codeId;        // 코드 id fk
    private String detailCode; // 세부코드 pk
    private String codeNameKor; //코드한글명
    private String codeNameEng; //코드영문명
    private String codeOther; //코드기타명
    private Integer isActive; // 사용여부
    private Long displayOrder; //표시순서
    private String remarks; // 비고
    private String etc1; //기타1
    private String etc2; //기타2
    private String etc3; //기타3
    private String etc4; //기타4

    @Builder
    public CodeDetail(String codeId, String detailCode, String codeNameKor, String codeNameEng, String codeOther, Integer isActive, Long displayOrder, String remarks, String etc1, String etc2, String etc3, String etc4) {
        this.codeId = codeId;
        this.detailCode = detailCode;
        this.codeNameKor = codeNameKor;
        this.codeNameEng = codeNameEng;
        this.codeOther = codeOther;
        this.isActive = isActive;
        this.displayOrder = displayOrder;
        this.remarks = remarks;
        this.etc1 = etc1;
        this.etc2 = etc2;
        this.etc3 = etc3;
        this.etc4 = etc4;
    }
}
