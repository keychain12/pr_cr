package com.example.demo.service;

import com.example.demo.domain.Code;
import com.example.demo.domain.CodeDetail;
import com.example.demo.dto.code.CodeBatchRequest;
import com.example.demo.dto.code.CodeDetailBatchRequest;
import com.example.demo.dto.code.CodeDetailRequest;
import com.example.demo.dto.code.CodeRequest;
import com.example.demo.repository.CodeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CodeService {

    private final CodeRepository codeRepository;

    // 코드 list 가져오기
    public List<Code> getCodeList(String code, String codeCategoryName, Boolean isActive) {
        return codeRepository.getCodeList(code,codeCategoryName,isActive);
    }

    public void processBatchCodes(CodeBatchRequest batchRequest) { // 등록 수정 삭제 배치

        // insert 데이터를 받았는지 if 문으로 확인
        if (batchRequest.getInsertCodes() != null && !batchRequest.getInsertCodes().isEmpty()) {
            // 1. insert 처리
            for (CodeRequest codeRequest : batchRequest.getInsertCodes()) {  // 반복문으로 꺼내서
                Code code = codeRequest.toEntity();    //  객체에 집어놓고
                codeRepository.save(code);                  // 저장
            }

        }
        if (batchRequest.getUpdateCodes() != null && !batchRequest.getUpdateCodes().isEmpty()) {
            // 2.update 처리
            for (CodeRequest codeRequest : batchRequest.getUpdateCodes()) {
                Code code = codeRequest.toEntity();
                codeRepository.modify(code);
            }
        }
        if (batchRequest.getDeleteCodes() != null && !batchRequest.getDeleteCodes().isEmpty()) {
            // 3.delete 처리
            for (CodeRequest codeRequest : batchRequest.getDeleteCodes()) {
                Code code = codeRequest.toEntity();
                codeRepository.delete(code.getCodeId());
            }
        }




    }

    //  코드상세 list 가져오기
    public List<CodeDetail> getCodeDetailList(Long codeId) {
        return codeRepository.getCodeDetailList(codeId);
    }

    // 코드 상세 일괄 cud 처리
    public void processBatchCodeDetail(CodeDetailBatchRequest request) {

        if (request.getInsertDetailCodes() != null && !request.getInsertDetailCodes().isEmpty()) {
            for (CodeDetailRequest detailRequest : request.getInsertDetailCodes()) {
                CodeDetail entity = detailRequest.toEntity();
                entity.setCodeId(request.getCodeId());
                codeRepository.detailSave(entity);
            }
        }
        if (request.getUpdateDetailCodes() != null && !request.getUpdateDetailCodes().isEmpty()) {
            for (CodeDetailRequest detailRequest : request.getUpdateDetailCodes()) {
                CodeDetail entity = detailRequest.toEntity();
                codeRepository.detailModify(entity);
            }
        }
        if (request.getDeleteDetailCodes() != null && !request.getDeleteDetailCodes().isEmpty()) {
            for (CodeDetailRequest detailRequest : request.getDeleteDetailCodes()) {
                CodeDetail entity = detailRequest.toEntity();
                codeRepository.detailDelete(entity.getCodeDetailId());
            }
        }

    }
}
