package com.example.demo.service;

import com.example.demo.entity.LichSuHoaDon;
import com.example.demo.entity.Voucher;
import com.example.demo.infrastructure.common.PhanTrang;
import com.example.demo.infrastructure.response.LichSuHoaDonReponse;
import com.example.demo.infrastructure.response.VoucherResponse;
import org.springframework.http.ResponseEntity;

public interface VoucherService {

    PhanTrang<VoucherResponse> getAll(Integer page);

    Voucher getOne(Long id);
    ResponseEntity<?> add(Voucher voucher);
    Voucher update(Long id, Voucher voucher);
    Voucher delete(Long id);
}
