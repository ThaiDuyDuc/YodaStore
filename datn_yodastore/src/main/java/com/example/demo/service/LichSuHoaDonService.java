package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.LichSuHoaDon;
import com.example.demo.infrastructure.common.PhanTrang;
import com.example.demo.infrastructure.response.HoaDonResponse;
import com.example.demo.infrastructure.response.LichSuHoaDonReponse;

public interface LichSuHoaDonService {

    PhanTrang<LichSuHoaDonReponse> getAll(Integer page);

    LichSuHoaDon getOne(Long id);
    LichSuHoaDon add(LichSuHoaDon lichSuHoaDon);
    LichSuHoaDon update(Long id, LichSuHoaDon lichSuHoaDon);
    LichSuHoaDon delete(Long id);
}
