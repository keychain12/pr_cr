package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parts {

    private Long id; // 시퀀스
    private String name; // 품명
    private Long inNumber; // 부분품 번호
    private String inNIIN;  // NINN
    private String inPartsName; // 부분품명
    private String inCode;  //불출단위코드
    private String fun;     //정비창기능
    private String material;  // 재질
    private Long inPrice;    //단가
    private String thickness;//두께
    private String deleteTime;//녹 제거시간
    private String color;   //색깔
    private Long lotSize;    //LOT크기
    private Long lotSizeMax; //LOT크기 max
    private Long lotSizeMin;     //LOT크기 min
    private String category;  //자재종별
    private String time;        // 소요시간
    private String isVirtualPart;   //가상부분품 여부
    private String isInUse;     //사용여부
    private String isForeignDeployment; //해외파병장비여부

    @Builder
    public Parts(Long id, String name, Long inNumber, String inNIIN, String inPartsName, String inCode, String fun, String material, Long inPrice, String thickness, String deleteTime, String color, Long lotSize, Long lotSizeMax, Long lotSizeMin, String category, String time, String isVirtualPart, String isInUse, String isForeignDeployment) {
        this.id = id;
        this.name = name;
        this.inNumber = inNumber;
        this.inNIIN = inNIIN;
        this.inPartsName = inPartsName;
        this.inCode = inCode;
        this.fun = fun;
        this.material = material;
        this.inPrice = inPrice;
        this.thickness = thickness;
        this.deleteTime = deleteTime;
        this.color = color;
        this.lotSize = lotSize;
        this.lotSizeMax = lotSizeMax;
        this.lotSizeMin = lotSizeMin;
        this.category = category;
        this.time = time;
        this.isVirtualPart = isVirtualPart;
        this.isInUse = isInUse;
        this.isForeignDeployment = isForeignDeployment;
    }

    public Parts() {

    }


}
