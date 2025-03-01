package com.yoda.yodatore.service;

import com.yoda.yodatore.entity.Account;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.request.AccountRequest;
import com.yoda.yodatore.infrastructure.response.AccountResponse;

public interface AccountService {
    PhanTrang<AccountResponse> getAll(AccountRequest request);

    Account getOne(Long id, String roleName);

    Account create(AccountRequest request, String roleName);

    Account update(Long id, AccountRequest request);

    Account delete(Long id);
}
