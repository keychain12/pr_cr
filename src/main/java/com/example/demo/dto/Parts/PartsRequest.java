package com.example.demo.dto.Parts;

import com.example.demo.domain.Parts;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PartsRequest {
    private Long id;
    private String name; // 품명
    private Long inNumber; // 부분품 번호
    private String inNIIN; // NINN
    private String inPartsName; // 부분품명
    private String inCode; // 불출단위코드
    private String fun; // 정비창기능
    private String material; // 재질
    private Long inPrice; // 단가
    private String thickness; // 두께
    private String deleteTime; // 녹 제거시간
    private String color; // 색깔
    private Long   lotSize; // LOT크기
    private Long   lotSizeMax; // LOT크기 max
    private Long   lotSizeMin; // LOT크기 min
    private String category; // 자재종별
    private String time; // 소요시간
    private String isVirtualPart; // 가상부분품 여부
    private String isInUse; // 사용여부
    private String isForeignDeployment; // 해외파병장비여부

    public Parts toEntity() {
        return Parts.builder()
                .id(this.id)
                .name(this.name)
                .inNumber(this.inNumber)
                .inNIIN(this.inNIIN)
                .inPartsName(this.inPartsName)
                .inCode(this.inCode)
                .fun(this.fun)
                .material(this.material)
                .inPrice(this.inPrice)
                .thickness(this.thickness)
                .deleteTime(this.deleteTime)
                .color(this.color)
                .lotSize(this.lotSize)
                .lotSizeMax(this.lotSizeMax)
                .lotSizeMin(this.lotSizeMin)
                .category(this.category)
                .time(this.time)
                .isVirtualPart(this.isVirtualPart)
                .isInUse(this.isInUse)
                .isForeignDeployment(this.isForeignDeployment)
                .build();
    }

}


