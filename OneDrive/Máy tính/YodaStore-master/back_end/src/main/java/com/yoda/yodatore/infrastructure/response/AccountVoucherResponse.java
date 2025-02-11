package com.yoda.yodatore.infrastructure.response;


import com.yoda.yodatore.entity.Account;
import com.yoda.yodatore.entity.Voucher;

public interface AccountVoucherResponse {

     Account getAccount();

     Voucher getVoucher();

}
