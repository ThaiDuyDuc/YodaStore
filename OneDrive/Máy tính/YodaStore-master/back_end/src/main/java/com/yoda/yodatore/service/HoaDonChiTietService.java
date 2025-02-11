package com.yoda.yodatore.service;


import com.yoda.yodatore.entity.HoaDonChiTiet;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.response.HoaDonChiTietResponse;

public interface HoaDonChiTietService {

    PhanTrang<HoaDonChiTietResponse> getAll(Integer page);

    HoaDonChiTiet getOne(Long id);
    HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);
    HoaDonChiTiet update(Long id, HoaDonChiTiet hoaDonChiTiet);
    HoaDonChiTiet delete(Long id);

}
