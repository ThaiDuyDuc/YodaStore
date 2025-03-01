package com.yoda.yodatore.infrastructure.converter;


import com.yoda.yodatore.entity.MauSac;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import org.springframework.stereotype.Component;

@Component
public class MauSacConvert {

    public MauSac addconvertRequest(MauSacRequest request){
        MauSac mauSac = MauSac.builder()
                .name(request.getName())
                .build();
        return mauSac;
    }

    public MauSac convertRequestToEntity(MauSac entity, MauSacRequest request){
        entity.setName(request.getName());
        return entity;
    }
}
