package com.yoda.yodatore.service;


import com.yoda.yodatore.entity.LichSuHoaDon;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.response.LichSuHoaDonReponse;

public interface LichSuHoaDonService {

    PhanTrang<LichSuHoaDonReponse> getAll(Integer page);

    LichSuHoaDon getOne(Long id);
    LichSuHoaDon add(LichSuHoaDon lichSuHoaDon);
    LichSuHoaDon update(Long id, LichSuHoaDon lichSuHoaDon);
    LichSuHoaDon delete(Long id);
}
