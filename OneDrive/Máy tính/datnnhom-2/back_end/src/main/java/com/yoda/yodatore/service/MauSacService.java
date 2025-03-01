package com.yoda.yodatore.service;

import com.yoda.yodatore.entity.MauSac;

import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import com.yoda.yodatore.infrastructure.response.MauSacResponse;


public interface MauSacService {
    PhanTrang<MauSacResponse> getAll(MauSacRequest request);

    MauSac getOne(Long id);
    MauSac create(MauSacRequest request);
    MauSac update(Long id, MauSacRequest request);
    MauSac delete(Long id);
}
