package com.yoda.yodatore.service;

import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.request.SanPhamChiTietRequest;
import com.yoda.yodatore.infrastructure.response.SanPhamChiTietReponse;
import com.yoda.yodatore.entity.SanPhamChiTiet;

import java.util.List;

public interface SanPhamChiTietService {
    PhanTrang<SanPhamChiTietReponse> getAll(SanPhamChiTietRequest request);
    SanPhamChiTiet getOne(Long id);
    String create(List<SanPhamChiTietRequest> list);
    SanPhamChiTiet update(Long id, SanPhamChiTietRequest request);
    SanPhamChiTiet delete(Long id);
}
