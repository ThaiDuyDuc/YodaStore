package com.yoda.yodatore.service;


import com.yoda.yodatore.entity.Voucher;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.response.VoucherResponse;
import org.springframework.http.ResponseEntity;

public interface VoucherService {

    PhanTrang<VoucherResponse> getAll(Integer page);

    Voucher getOne(Long id);
    ResponseEntity<?> add(Voucher voucher);
    Voucher update(Long id, Voucher voucher);
    Voucher delete(Long id);
}
