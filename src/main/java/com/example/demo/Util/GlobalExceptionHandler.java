package com.example.demo.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler { // 전역 예외처리
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(IllegalArgumentException.class) // 잘못된 파라미터에 대한 에러처리
    public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(IllegalArgumentException e){

        ApiErrorResponse errorResponse = new ApiErrorResponse(
                "error",             // 상태
                "INVALID_INPUT",            // 에러코드
                e.getMessage()              // 에러메세지
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // 유효성 검사 실패 시 발생한 오류 메시지들 처리
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage) // 직접 getDefaultMessage() 사용
                .collect(Collectors.toList());

        ApiErrorResponse errorResponse = new ApiErrorResponse(
                "error",
                "VALIDATION_FAILED",
                String.join(", ", errors) // 에러 메시지들을 하나로 합쳐서 반환
        );


        // 로깅 (에러 메시지 기록)
        logger.error("Validation failed with errors: {}", String.join(", ", errors));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // 모든 예외 처리 (기본적인 Exception 을 처리하는 핸들러 추가)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleAllExceptions(Exception e) {
        // 모든 예외를 포괄적으로 처리
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                "error",             // 상태
                "INTERNAL_SERVER_ERROR", // 에러코드
                e.getMessage()       // 에러메시지
        );

        // 예외 로깅
        logger.error("Unexpected error occurred: {}", e.getMessage(), e);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
/*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) { // 이건 string으로 메세지만 반환
        // 유효성 검사 실패 시 발생한 오류 메시지들 처리
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage) // 직접 getDefaultMessage() 사용
                .collect(Collectors.toList());

        // 에러 메시지들을 하나로 합쳐서 문자열로 반환
        String errorMessage = String.join(", ", errors);

        // 로깅 (에러 메시지 기록)
        logger.error("Validation failed with errors: {}", errorMessage);

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }*/
}
