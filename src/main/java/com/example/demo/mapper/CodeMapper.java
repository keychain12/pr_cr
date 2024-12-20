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

    void delete(String codeId);

    @Select("select * from codeDetailT where codeId = #{codeId} order by displayOrder")
    List<CodeDetail> getCodeDetailList(String codeId);

    void detailSave(CodeDetail entity);

    void detailModify(CodeDetail entity);

    void detailDelete(String codeDetailId);





    // insert 동적 배치쿼리 테스트 실패
    void insertBatch(List<CodeDetail> list);

    // update 동적 쿼리 테스트 실패
    void updateBatch(List<CodeDetail> list);

    // delete 동적 배치쿼리 성공
    void deleteBatch(List<String> list);





    int getTotalCodeCount(String code, String codeCategoryName, Boolean isActive);

    Long getTotalCount();


    boolean existsByCodeId(String codeId);

    boolean existsByDetailCode(@Param("detailCode") String detailCode,@Param("codeId") String codeId);
}
