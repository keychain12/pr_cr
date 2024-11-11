package com.example.demo.Util;

import com.example.demo.domain.Parts;
import com.example.demo.service.PartsService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final PartsService partsService;

    @PostConstruct
    public void init() {
      /*  Parts a1 = Parts.builder()
                .name("외피,전기 연결용")
                .inNumber(60504046L)
                .inNIIN("005728178")
                .inPartsName("외피")
                .inCode("059")
                .fun("기능")  // fun 필드는 값이 없으므로 null로 설정 (원하는 값을 넣으세요)
                .material("재질")  // material 필드도 값이 없으므로 null (원하는 값을 넣으세요)
                .inPrice(305L)
                .thickness("두께")  // thickness도 null로 설정
                .deleteTime("제거시간")  // deleteTime도 null로 설정
                .color("색깔")  // color도 null로 설정
                .LOTSize(34.2)  // LOTSize도 null로 설정
                .LOTSizeMax(35.1)  // LOTSizeMax도 null로 설정
                .LOTSizeMin(54.23)  // LOTSizeMin도 null로 설정
                .category("자재종별")  // category도 null로 설정
                .time("시간")  // time도 null로 설정
                .isVirtualPart(true)  // 기본값 설정, 필요에 따라 변경 가능
                .isInUse(true)  // 기본값 설정, 필요에 따라 변경 가능
                .isForeignDeployment(false)  // 기본값 설정, 필요에 따라 변경 가능
                .build();

        Parts b1 = Parts.builder()
                .name("내피,보호용")  // 예시로 다른 값 입력
                .inNumber(12345678L)
                .inNIIN("123456789")
                .inPartsName("내피")
                .inCode("060")
                .fun(null)
                .material(null)
                .inPrice(500L)
                .thickness(null)
                .deleteTime(null)
                .color(null)
                .LOTSize(null)
                .LOTSizeMax(null)
                .LOTSizeMin(null)
                .category(null)
                .time(null)
                .isVirtualPart(false)
                .isInUse(true)
                .isForeignDeployment(false)
                .build();

        Parts c1 = Parts.builder()
                .name("중간 층, 절연용")  // 예시로 다른 값 입력
                .inNumber(98765432L)
                .inNIIN("987654321")
                .inPartsName("중간 층")
                .inCode("061")
                .fun(null)
                .material(null)
                .inPrice(450L)
                .thickness(null)
                .deleteTime(null)
                .color(null)
                .LOTSize(null)
                .LOTSizeMax(null)
                .LOTSizeMin(null)
                .category(null)
                .time(null)
                .isVirtualPart(false)
                .isInUse(true)
                .isForeignDeployment(false)
                .build();


        partsService.save(a1);
        partsService.save(b1);
        partsService.save(c1);*/
    }
}
