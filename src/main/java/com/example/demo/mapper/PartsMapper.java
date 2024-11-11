package com.example.demo.mapper;

import com.example.demo.domain.Parts;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
@MapperScan("com.example.demo.mapper")
public interface PartsMapper {

    List<Parts> getList();

    int save(Parts parts);

    @Delete("delete from parts where id = #{id}")
    void remove(Long id);

    boolean existByNum(Long inNumber);
}
