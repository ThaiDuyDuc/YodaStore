package com.example.demo.service;

import com.example.demo.entity.AccountVoucher;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.infrastructure.common.PhanTrang;
import com.example.demo.infrastructure.response.AccountVoucherResponse;
import com.example.demo.infrastructure.response.HoaDonChiTietResponse;

public interface AccountVoucherService {

    PhanTrang<AccountVoucherResponse> getAll(Integer page);

    AccountVoucher getOne(Long id);
    AccountVoucher add(AccountVoucher accountVoucher);
    AccountVoucher update(Long id, AccountVoucher accountVoucher);
    AccountVoucher delete(Long id);

}
