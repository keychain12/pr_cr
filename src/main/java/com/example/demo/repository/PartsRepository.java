package com.example.demo.repository;

import com.example.demo.domain.Parts;
import com.example.demo.mapper.PartsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PartsRepository {

    private final PartsMapper partsMapper;

    public List<Parts> getList() {
        return partsMapper.getList();
    }

    public int save(Parts parts) {
     return    partsMapper.save(parts);
    }

    public void remove(Long id) {
        partsMapper.remove(id);
    }

    public boolean existByNum(Long inNumber) {
       return partsMapper.existByNum(inNumber);
    }
}
