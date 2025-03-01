package com.yoda.yodatore.service;

import com.yoda.yodatore.entity.DanhMuc;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.request.DanhMucRequest;
import com.yoda.yodatore.infrastructure.response.DanhMucResponse;
import com.yoda.yodatore.infrastructure.response.DeResponse;

public interface DanhMucService {
    PhanTrang<DanhMucResponse> getAll(DanhMucRequest request);

    DanhMuc getOne(Long id);

    DanhMuc add(DanhMucRequest request);

    DanhMuc update(Long id, DanhMucRequest request);

    DanhMuc delete(Long id);
}
