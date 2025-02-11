package com.yoda.yodatore.service;


import com.yoda.yodatore.entity.AccountVoucher;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.response.AccountVoucherResponse;

public interface AccountVoucherService {

    PhanTrang<AccountVoucherResponse> getAll(Integer page);

    AccountVoucher getOne(Long id);
    AccountVoucher add(AccountVoucher accountVoucher);
    AccountVoucher update(Long id, AccountVoucher accountVoucher);
    AccountVoucher delete(Long id);

}
