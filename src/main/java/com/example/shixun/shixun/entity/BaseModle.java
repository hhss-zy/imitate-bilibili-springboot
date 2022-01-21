package com.example.shixun.shixun.entity;

import lombok.Data;

import java.util.List;

@Data
public class BaseModle <T>{
    int code;
    String mes;
    T data;
    List<T> datas;

    public BaseModle(int code, String mes,T data) {
        this.code = code;
        this.mes = mes;
        this.data=data;
    }

    public BaseModle(int code, String mes, List<T> datas) {
        this.code = code;
        this.mes = mes;
        this.datas = datas;
    }
}
