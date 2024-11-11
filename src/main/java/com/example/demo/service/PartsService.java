package com.example.demo.service;

import com.example.demo.domain.Parts;
import com.example.demo.repository.PartsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class PartsService {

    private final PartsRepository partsRepository;

    private static final List<Parts> list = new ArrayList<>();

    private Long id = 0L;


    public int save(Parts parts) {

        // 부분품 번호 중복확인
//        numberExist(parts);

        if (partsRepository.existByNum(parts.getInNumber())) {  // 부분품 번호 중복확인
            throw new IllegalArgumentException("이미 존재하는 부분품번호입니다.");
        }


        return partsRepository.save(parts);
    }



    private static void numberExist(Parts parts) {// 부분품 번호 중복확인
        if (!list.isEmpty()) {


            boolean isPartInList = list.stream()
                    .map(a -> Objects.equals(a.getInNumber(), parts.getInNumber()))
                    .findAny().orElseThrow(() -> new IllegalArgumentException("데이터 없음"));


            if (isPartInList) {
                throw new IllegalArgumentException("중복임");
            }
        }
    }

    public List<Parts> getList() {


        return partsRepository.getList();
    }

    public void delete(Long id) {


        Parts find = list.stream()
                .filter(a -> Objects.equals(a.getId(), id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("아이디가 없습니다."));

        list.remove(find);
    }

    public void remove(Long id) {
        partsRepository.remove(id);
    }

}
