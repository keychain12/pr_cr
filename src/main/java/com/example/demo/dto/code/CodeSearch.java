package com.example.demo.dto.code;

import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CodeSearch {
    private String code;
    private String codeCategoryName;
    private Boolean isActive;
}
