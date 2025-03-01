package com.yoda.yodatore.service;


import com.yoda.yodatore.entity.ThuongHieu;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.request.ThuongHieuRequest;
import com.yoda.yodatore.infrastructure.response.ThuongHieuResponse;

public interface ThuongHieuService {
    PhanTrang<ThuongHieuResponse> getAll(ThuongHieuRequest request);

    ThuongHieu getOne(Long id);

    ThuongHieu add(ThuongHieuRequest request);

    ThuongHieu update(Long id, ThuongHieuRequest request);

    ThuongHieu delete(Long id);

}
