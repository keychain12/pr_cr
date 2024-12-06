package com.example.demo.repository;

import com.example.demo.domain.Code;
import com.example.demo.domain.CodeDetail;
import com.example.demo.mapper.CodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeRepository {
    private final CodeMapper codeMapper;

     public List<Code> getCodeList(String code, String codeCategoryName, Boolean isActive) {
        return codeMapper.getCodeList(code,codeCategoryName,isActive);
    }


    public void save(Code code) {
        codeMapper.save(code);
    }

    public void modify(Code code) {
        codeMapper.modify(code);
    }

    public void delete(String codeId) {
        codeMapper.delete(codeId);
    }

    public List<CodeDetail> getCodeDetailList(String codeId) {
        return codeMapper.getCodeDetailList(codeId);
    }


    public void detailSave(CodeDetail entity) {
        codeMapper.detailSave(entity);
    }

    public void detailModify(CodeDetail entity) {
        codeMapper.detailModify(entity);
    }

    public void detailDelete(String codeDetailId) {
        codeMapper.detailDelete(codeDetailId);
    }




    public void insertBatch(List<CodeDetail> list) {
        codeMapper.insertBatch(list);
    }

    public void updateBatch(List<CodeDetail> list) {
        codeMapper.updateBatch(list);
    }

    public void deleteBatch(List<String> list) {
        codeMapper.deleteBatch(list);
    }


    public Long getTotalCount() {
        return codeMapper.getTotalCount();
    }

    public boolean existsByCodeId(String codeId) {
        return codeMapper.existsByCodeId(codeId);
    }

    public boolean existsByDetailCode(String detailCode, String codeId) {
        return codeMapper.existsByDetailCode(detailCode , codeId);
    }
}
