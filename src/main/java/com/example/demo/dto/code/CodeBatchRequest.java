package com.example.demo.dto.code;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class CodeBatchRequest {
    @Valid
    private List<CodeRequest> insertCodes;
    @Valid
    private List<CodeRequest> updateCodes;
    @Valid
    private List<CodeRequest> deleteCodes; // 프론트에서 id값만 보내는걸 몰라서 그냥 데이터로받음;
}
