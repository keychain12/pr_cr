package com.example.demo.controller;

import com.example.demo.domain.Parts;
import com.example.demo.dto.Parts.PartsRequest;
import com.example.demo.dto.Parts.PartsResponse;
import com.example.demo.service.PartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class PartsController {

    private final PartsService partsService;


    @GetMapping("/parts/list")  // 조회 api
    public ResponseEntity<PartsResponse<Parts>> getList() {


        List<Parts> result = partsService.getList();

//         String jsonResponse = Result.result("parts_Info", result);

        PartsResponse<Parts> response = new PartsResponse<>(result);


        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }



    @PostMapping("/api/parts") //  추가
    public ResponseEntity<String> createParts(@RequestBody PartsRequest partsRequest) {


        System.out.println("partsRequest = " + partsRequest.toString());

        Parts parts = partsRequest.toEntity();

        int result = partsService.save(parts);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(partsRequest.toString());
    }

    @DeleteMapping("/api/parts") // 삭제 api
    public ResponseEntity<String> deleteParts(@RequestBody PartsRequest id) {


        partsService.remove(id.getId());

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("ㅎㅇㅇ");
    }

    @PutMapping("/api/parts")
    public ResponseEntity<String> modifyParts(@RequestBody PartsRequest id) {

        System.out.println("id = " + id.toString());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("ㅎㅇㅇ");
    }







}
