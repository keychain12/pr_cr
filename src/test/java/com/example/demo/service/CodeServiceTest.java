package com.example.demo.service;

import com.example.demo.dto.code.CodeDetailBatchRequest;
import com.example.demo.dto.code.CodeDetailRequest;
import com.example.demo.repository.CodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
class CodeServiceTest {

    @Autowired
    private CodeService codeService;

    @Test
    void testInsertBatchPerformance() {
        // 시작 시간 기록
        long startTime = System.currentTimeMillis();

        // 실제 데이터 삽입 수행
        codeService.processBatchCodeDetail(createBatchRequest());

        // 종료 시간 기록
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " ms");

        // 데이터가 실제로 삽입되었는지 확인 가능
        // 하지만 테스트가 끝난 후 데이터는 롤백됨.
    }

    private CodeDetailBatchRequest createBatchRequest() {
        // 데이터 생성 로직 (테스트 데이터 준비)
        CodeDetailBatchRequest request = new CodeDetailBatchRequest();
        request.setCodeId(1L);

        List<CodeDetailRequest> insertDetailCodes = new ArrayList<>();
        for (int i = 50; i < 10050; i++) { // 천만 개 대신 1만 개 삽입 예시
            insertDetailCodes.add(new CodeDetailRequest(
                    (long) i,
                    1L,
                    "Detail" + i,
                    "코드한글명" + i,
                    "CodeName" + i,
                    "기타" + i,
                    1,
                    (long) i,
                    "비고 " + i,
                    "기타1", "기타2", "기타3", "기타4"
            ));
        }
        request.setInsertDetailCodes(insertDetailCodes);
        return request;
    }


}