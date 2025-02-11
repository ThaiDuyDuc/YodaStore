package com.yoda.yodatore.service.impl;


import com.yoda.yodatore.entity.AccountVoucher;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.response.AccountVoucherResponse;
import com.yoda.yodatore.repository.AccountVoucherRepository;
import com.yoda.yodatore.service.AccountVoucherService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountVoucherImpl implements AccountVoucherService {

    @Autowired
    private AccountVoucherRepository repository;

    @Override
    public PhanTrang<AccountVoucherResponse> getAll(Integer page) {
        return new PhanTrang<>(repository.getAll(PageRequest.of(page - 1, 5)));
    }

    @Override
    public AccountVoucher getOne(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public AccountVoucher add(AccountVoucher accountVoucher) {
        return repository.save(accountVoucher);
    }

    @Override
    public AccountVoucher update(Long id, AccountVoucher accountVoucher) {

        AccountVoucher accountVoucher1 = this.getOne(id);
        accountVoucher1.setAccount(accountVoucher.getAccount());
        accountVoucher1.setVoucher(accountVoucher.getVoucher());

        return repository.save(accountVoucher1);
    }

    @Override
    public AccountVoucher delete(Long id) {
        Optional<AccountVoucher> accountVoucher = repository.findById(id);
        if(accountVoucher.isEmpty()){
            throw new EntityNotFoundException("Không tìm thấy lịch sử hóa đơn có ID: " + id);
        }
        repository.deleteById(id);

        return accountVoucher.get();    }
}
