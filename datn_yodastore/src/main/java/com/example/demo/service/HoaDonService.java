package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import com.example.demo.infrastructure.common.PhanTrang;
import com.example.demo.infrastructure.response.HoaDonResponse;

public interface HoaDonService {

    PhanTrang<HoaDonResponse> getAll( Integer page);

    HoaDon getOne(Long id);
    HoaDon add(HoaDon hoaDon);
    HoaDon update(Long id, HoaDon hoaDon);
    HoaDon delete(Long id);

}
