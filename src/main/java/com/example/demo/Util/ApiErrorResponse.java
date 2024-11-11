package com.example.demo.Util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiErrorResponse {
    private String status;
    private String errorCode;
    private String message;

    public ApiErrorResponse(String status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

}
