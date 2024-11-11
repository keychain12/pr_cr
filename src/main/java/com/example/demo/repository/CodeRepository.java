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

    public void delete(Long codeId) {
        codeMapper.delete(codeId);
    }

    public List<CodeDetail> getCodeDetailList(Long codeId) {
        return codeMapper.getCodeDetailList(codeId);
    }

    public void detailSave(CodeDetail entity) {
        codeMapper.detailSave(entity);
    }

    public void detailModify(CodeDetail entity) {
        codeMapper.detailModify(entity);
    }

    public void detailDelete(Long codeDetailId) {
        codeMapper.detailDelete(codeDetailId);
    }
}
