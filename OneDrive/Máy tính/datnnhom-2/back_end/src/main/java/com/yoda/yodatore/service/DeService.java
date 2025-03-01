package com.yoda.yodatore.service;

import com.yoda.yodatore.entity.De;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.request.DeRequest;
import com.yoda.yodatore.infrastructure.response.DeResponse;

public interface DeService {
    PhanTrang<DeResponse> getAll(DeRequest request);

    De getOne(Long id);

    De add(DeRequest request);

    De update(Long id, DeRequest request);

    De delete(Long id);
}
