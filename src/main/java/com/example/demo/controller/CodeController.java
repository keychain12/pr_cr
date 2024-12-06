package com.example.demo.controller;

import com.example.demo.Util.Result;
import com.example.demo.domain.Code;
import com.example.demo.domain.CodeDetail;
import com.example.demo.dto.code.*;
import com.example.demo.service.CodeService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CodeController {

    private final CodeService codeService;


    @GetMapping("/code") // 코드 조회 api
    public ResponseEntity<String> getList(@RequestParam(value = "code" , required = false) String code,
                                          @RequestParam(value = "codeCategoryName", required = false) String codeCategoryName,
                                          @RequestParam(value = "isActive" , required = false) Boolean isActive,
                                          @RequestParam(value = "pageNum" ,defaultValue = "1") int pageNum,
                                          @RequestParam(value = "pageSize" , defaultValue = "10")int pageSize) {

        System.out.println("code = " + code);
        System.out.println("codeCategoryName = " + codeCategoryName);
        System.out.println("isActive = " + isActive);


        // 페이징처리
        int startNum = (pageNum - 1) * pageSize;



        List<Code> codeList =  codeService.getCodeList(code,codeCategoryName,isActive);


        String jsonResponse = Result.result("codeList",codeList);


        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonResponse);
    }

    @GetMapping("/code/count")
    public ResponseEntity<String> count() {


        Long totalCount = codeService.getTotalCount();

        System.out.println("totalCount = " + totalCount);

        String jsonResponse = Result.result("totalCount",totalCount);

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonResponse);
    }


    @PostMapping("/code/batch") //  insert update delete batch api
    public ResponseEntity<String> insertCode(@Valid @RequestBody CodeBatchRequest batchRequest) {

        System.out.println("batchRequest = " + batchRequest.toString());

        codeService.processBatchCodes(batchRequest);


        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("successfully");
    }

    @GetMapping("/code/detail")// 코드상세 조회 api
    public ResponseEntity<String> getCodeDetailList(@RequestParam(value = "codeId") String codeId) {

        System.out.println("codeId = " + codeId);
        List<CodeDetail> codeDetailList = codeService.getCodeDetailList(codeId);


        String jsonResponse = Result.result("codeDetailList", codeDetailList);

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonResponse);
    }

    @PostMapping("/code/detail/batch") // 코드상세  cud 배치
    public ResponseEntity<String> codeDetailBatch(@Valid @RequestBody CodeDetailBatchRequest request) {


        System.out.println("request = " + request.toString());

        codeService.processBatchCodeDetail(request);

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("successfully");
    }


}
