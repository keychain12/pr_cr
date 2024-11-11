package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CodeDetail {
    private Long codeDetailId; // 코드상세 id pk
    private Long codeId;        // 코드 id fk
    private String detailCode; // 세부코드
    private String codeNameKor; //코드한글명
    private String codeNameEng; //코드영문명
    private String codeOther; //코드기타명
    private Boolean isActive; // 사용여부
    private Long displayOrder; //표시순서

    @Builder
    public CodeDetail(Long codeDetailId, Long codeId, String detailCode, String codeNameKor, String codeNameEng, String codeOther, Boolean isActive, Long displayOrder) {
        this.codeDetailId = codeDetailId;
        this.codeId = codeId;
        this.detailCode = detailCode;
        this.codeNameKor = codeNameKor;
        this.codeNameEng = codeNameEng;
        this.codeOther = codeOther;
        this.isActive = isActive;
        this.displayOrder = displayOrder;
    }

    @Override
    public String toString() {
        return "CodeDetail{" +
                "codeDetailId=" + codeDetailId +
                ", codeId=" + codeId +
                ", detailCode='" + detailCode + '\'' +
                ", codeNameKor='" + codeNameKor + '\'' +
                ", codeNameEng='" + codeNameEng + '\'' +
                ", codeOther='" + codeOther + '\'' +
                ", isActive=" + isActive +
                ", displayOrder=" + displayOrder +
                '}';
    }
}
