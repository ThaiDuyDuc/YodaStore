package com.yoda.yodatore.infrastructure.converter;


import com.yoda.yodatore.entity.ThuongHieu;
import com.yoda.yodatore.infrastructure.request.KichThuocRequest;
import com.yoda.yodatore.infrastructure.request.ThuongHieuRequest;
import org.springframework.stereotype.Component;

@Component
public class ThuongHieuConvert {
    public ThuongHieu addconvertRequest(ThuongHieuRequest request){
        ThuongHieu thuongHieu = ThuongHieu.builder()
                .name(request.getName())
                .build();
        return thuongHieu;
    }
    public ThuongHieu convertRequestToEntity(ThuongHieu entity, ThuongHieuRequest request){
        entity.setName(request.getName());
        return entity;
    }
}
