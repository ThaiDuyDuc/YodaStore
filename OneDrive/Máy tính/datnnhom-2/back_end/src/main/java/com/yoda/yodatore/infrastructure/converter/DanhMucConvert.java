package com.yoda.yodatore.infrastructure.converter;


import com.yoda.yodatore.entity.DanhMuc;
import com.yoda.yodatore.infrastructure.request.DanhMucRequest;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import org.springframework.stereotype.Component;

@Component
public class DanhMucConvert {
    public DanhMuc addconvertRequest(DanhMucRequest request){
        DanhMuc danhMuc = DanhMuc.builder()
                .name(request.getName())
                .build();
        return danhMuc;
    }

    public DanhMuc convertRequestToEntity(DanhMuc entity, DanhMucRequest request){
        entity.setName(request.getName());
        return entity;
    }
}
