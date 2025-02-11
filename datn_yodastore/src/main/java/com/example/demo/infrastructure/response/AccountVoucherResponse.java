package com.example.demo.infrastructure.response;

import com.example.demo.entity.Account;
import com.example.demo.entity.Voucher;

public interface AccountVoucherResponse {

     Account getAccount();

     Voucher getVoucher();

}
