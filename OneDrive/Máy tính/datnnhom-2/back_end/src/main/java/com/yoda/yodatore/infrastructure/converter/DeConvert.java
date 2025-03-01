package com.yoda.yodatore.infrastructure.converter;


import com.yoda.yodatore.entity.De;
import com.yoda.yodatore.infrastructure.request.DeRequest;
import com.yoda.yodatore.infrastructure.request.KichThuocRequest;
import org.springframework.stereotype.Component;

@Component
public class DeConvert {
    public De addconvertRequest(DeRequest request){
        De de = De.builder()
                .name(request.getName())
                .build();
        return de;
    }
    public De convertRequestToEntity(De entity, DeRequest request){
        entity.setName(request.getName());
        return entity;
    }
}
