package com.yoda.yodatore.service;


import com.yoda.yodatore.entity.HoaDon;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.response.HoaDonResponse;

public interface HoaDonService {

    PhanTrang<HoaDonResponse> getAll(Integer page);

    HoaDon getOne(Long id);
    HoaDon add(HoaDon hoaDon);
    HoaDon update(Long id, HoaDon hoaDon);
    HoaDon delete(Long id);

}
