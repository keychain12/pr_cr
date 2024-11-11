package com.example.demo.dto.Parts;

import com.example.demo.Util.Result;
import lombok.*;

import java.util.List;


@Getter@Setter
public class PartsResponse<T> {
    private List<T> parts;

    public PartsResponse(List<T> parts) {
        this.parts = parts;
    }
}
