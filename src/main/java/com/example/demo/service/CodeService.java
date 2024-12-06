package com.example.demo.service;

import com.example.demo.domain.Code;
import com.example.demo.domain.CodeDetail;
import com.example.demo.dto.code.CodeBatchRequest;
import com.example.demo.dto.code.CodeDetailBatchRequest;
import com.example.demo.dto.code.CodeDetailRequest;
import com.example.demo.dto.code.CodeRequest;
import com.example.demo.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CodeService {

    private final CodeRepository codeRepository;

    @Transactional(readOnly = true)
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

                if (codeRepository.existsByCodeId(code.getCodeId())) { // 예외처리
                    throw new IllegalArgumentException("이미 존재하는 코드입니다 :  " + code.getCodeId());
                }

                codeRepository.save(code);                  //  이상없으면 저장


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
    @Transactional(readOnly = true)
    public List<CodeDetail> getCodeDetailList(String codeId) {
        return codeRepository.getCodeDetailList(codeId);
    }

    // 코드 상세 일괄 cud 처리
    public void processBatchCodeDetail(CodeDetailBatchRequest request) {

       if (request.getInsertDetailCodes() != null && !request.getInsertDetailCodes().isEmpty()) { // 기존 insert 쿼리
            for (CodeDetailRequest detailRequest : request.getInsertDetailCodes()) {
                CodeDetail entity = detailRequest.toEntity();
                entity.setCodeId(request.getCodeId());

                if (codeRepository.existsByDetailCode(entity.getDetailCode() , entity.getCodeId() )) { // 예외처리
                    throw new IllegalArgumentException("이미 존재하는 코드입니다 :  " + entity.getDetailCode());
                }

                codeRepository.detailSave(entity);
            }
        }


    /*   if (request.getInsertDetailCodes() != null && !request.getInsertDetailCodes().isEmpty()){ // 동적쿼리로 insert 되긴하는데 mybatis 쿼리문제있음
            List<CodeDetail> list = request.getInsertDetailCodes().stream()
                    .map(detailRequest ->{
                        CodeDetail entity = detailRequest.toEntity();
                        entity.setCodeId(request.getCodeId());
                        return entity;
                    })
                    .toList();
            codeRepository.insertBatch(list);
        }
*/
        if (request.getUpdateDetailCodes() != null && !request.getUpdateDetailCodes().isEmpty()) { // 기존 update 쿼리
            for (CodeDetailRequest detailRequest : request.getUpdateDetailCodes()) {
                CodeDetail entity = detailRequest.toEntity();
                codeRepository.detailModify(entity);
            }
        }
/*
        if (request.getUpdateDetailCodes() != null && !request.getUpdateDetailCodes().isEmpty()) { //update 배치쿼리 되긴하는데 쿼리 문제있음
            List<CodeDetail> list = request.getUpdateDetailCodes().stream()
                    .map(CodeDetailRequest::toEntity)
                    .toList();
            codeRepository.updateBatch(list);
        }*/
/*
            if (request.getDeleteDetailCodes() != null && !request.getDeleteDetailCodes().isEmpty()) { // 원래 기존 하나씩 쿼리날리는 삭제쿼리
            for (CodeDetailRequest detailRequest : request.getDeleteDetailCodes()) {
                CodeDetail entity = detailRequest.toEntity();
                codeRepository.detailDelete(entity.getDetailCode());
            }
        }*/

        if (request.getDeleteDetailCodes() != null && !request.getDeleteDetailCodes().isEmpty()) { // list로 넘기는 삭제 배치 쿼리인데 이건됨;
            List<String> list = request.getDeleteDetailCodes().stream()
                    .map(a -> {
                        CodeDetail entity = a.toEntity();
                        return entity.getDetailCode();
                    }).toList();
            codeRepository.deleteBatch(list);
        }


    }

    public Long getTotalCount() {
        return codeRepository.getTotalCount();
    }
}
