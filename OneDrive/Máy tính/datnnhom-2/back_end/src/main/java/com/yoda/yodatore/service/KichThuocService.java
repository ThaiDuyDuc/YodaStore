package com.yoda.yodatore.service;

import com.yoda.yodatore.entity.KichThuoc;
import com.yoda.yodatore.entity.MauSac;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.request.KichThuocRequest;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import com.yoda.yodatore.infrastructure.response.KichThuocResponse;
import com.yoda.yodatore.infrastructure.response.MauSacResponse;

public interface KichThuocService {
    PhanTrang<KichThuocResponse> getAll(KichThuocRequest request);

    KichThuoc getOne(Long id);

    KichThuoc add(KichThuocRequest request);

    KichThuoc update(Long id, KichThuocRequest request);

    KichThuoc delete(Long id);



}
