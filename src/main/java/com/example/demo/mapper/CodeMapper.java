package com.example.demo.mapper;

import com.example.demo.domain.Code;
import com.example.demo.domain.CodeDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CodeMapper {


    List<Code> getCodeList(@Param("code") String code,
                           @Param("codeCategoryName") String codeCategoryName,
                           @Param("isActive") Boolean isActive);


    void save(Code code);

    void modify(Code code);

    void delete(Long codeId);

    @Select("select * from codeDetail where codeId = #{codeId}")
    List<CodeDetail> getCodeDetailList(Long codeId);

    void detailSave(CodeDetail entity);

    void detailModify(CodeDetail entity);

    void detailDelete(Long codeDetailId);
}
