package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.infrastructure.common.PhanTrang;
import com.example.demo.infrastructure.response.HoaDonChiTietResponse;
import com.example.demo.infrastructure.response.HoaDonResponse;


public interface HoaDonChiTietService {

    PhanTrang<HoaDonChiTietResponse> getAll(Integer page);

    HoaDonChiTiet getOne(Long id);
    HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);
    HoaDonChiTiet update(Long id, HoaDonChiTiet hoaDonChiTiet);
    HoaDonChiTiet delete(Long id);

}
