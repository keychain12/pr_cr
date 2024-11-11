package com.example.demo.dto.code;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class CodeDetailBatchRequest {

    private Long codeId;

    @Valid
    private List<CodeDetailRequest> insertDetailCodes;
    @Valid
    private List<CodeDetailRequest> updateDetailCodes;
    @Valid
    private List<CodeDetailRequest> deleteDetailCodes;
}
