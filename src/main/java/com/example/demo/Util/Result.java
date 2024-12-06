package com.example.demo.Util;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Result {



    public static <T> String result(String name, List<T> list){
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        jsonObject.add(name, gson.toJsonTree(list));


        return gson.toJson(jsonObject);
    }

    public static <T> String result(String name, T data){
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(name, gson.toJsonTree(data));

        return gson.toJson(jsonObject);
    }


}
