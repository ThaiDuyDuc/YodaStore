package com.yoda.yodatore.infrastructure.converter;


import com.yoda.yodatore.entity.KichThuoc;

import com.yoda.yodatore.entity.MauSac;
import com.yoda.yodatore.infrastructure.request.KichThuocRequest;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import org.springframework.stereotype.Component;

@Component
public class KichThuocConvert {

    public KichThuoc addconvertRequest(KichThuocRequest request){
        KichThuoc kichThuoc = KichThuoc.builder()
                .name(request.getName())
                .build();
        return kichThuoc;
    }
    public KichThuoc convertRequestToEntity(KichThuoc entity, KichThuocRequest request){
        entity.setName(request.getName());
        return entity;
    }

}
