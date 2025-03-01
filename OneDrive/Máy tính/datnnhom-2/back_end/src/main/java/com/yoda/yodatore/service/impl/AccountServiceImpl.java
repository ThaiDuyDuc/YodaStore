package com.yoda.yodatore.service.impl;

import com.yoda.yodatore.entity.Account;
import com.yoda.yodatore.entity.Address;
import com.yoda.yodatore.infrastructure.common.GenCode;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.converter.AccountConvert;
import com.yoda.yodatore.infrastructure.converter.AddressConvert;
import com.yoda.yodatore.infrastructure.exception.NgoaiLe;
import com.yoda.yodatore.infrastructure.request.AccountRequest;
import com.yoda.yodatore.infrastructure.response.AccountResponse;
import com.yoda.yodatore.repository.*;
import com.yoda.yodatore.service.*;
import com.yoda.yodatore.util.CloudinaryUtils;
import com.yoda.yodatore.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AccountConvert accountConvert;
    @Autowired
    private AddressConvert addressConvert;
    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private CloudinaryUtils cloudinaryUtils;

    @Override
    public PhanTrang<AccountResponse> getAll(AccountRequest request) {
        Pageable pageable = PageRequest.of(request.getPage()-1, request.getSizePage());
        return new PhanTrang<>(accountRepository.getAll(request, pageable));
    }

    @Override
    public Account getOne(Long id, String roleName) {
        return accountRepository.getOne(id, roleName);
    }

    @Override
    @Transactional
    public Account create(AccountRequest request, String roleName) {
        if (accountRepository.existsByUsernameAndUsernameNot(request.getUsername(), ""))
            throw new NgoaiLe("Username đã tồn tại!");
        if (accountRepository.existsByEmailAndEmailNot(request.getEmail(), ""))
            throw new NgoaiLe("Email đã tồn tại!");
        if (accountRepository.existsByPhoneNumberAndPhoneNumberNot(request.getPhoneNumber(), ""))
            throw new NgoaiLe("SDT đã tồn tại!");
        if (accountRepository.existsByCccdAndCccdNot(request.getCccd(), ""))
            throw new NgoaiLe("Mã định danh đã tồn tại!");

        String randomPassword = GenCode.randomPassword();
        Account account = accountConvert.convertRequestToEntity(request);
        account.setRole(roleRepository.findByName(roleName));
        account.setPassword(randomPassword);
        account.setAvatar("defaultAvatar.jpg");
        Account accountSave = accountRepository.save(account);
        if (accountSave != null) {
            Address address = addressConvert.convertRequestToEntity(request.getAddress());
            address.setAccount(accountSave);
            addressRepository.save(address);
            if (request.getAvatar() != null)
                accountSave.setAvatar(String.valueOf(cloudinaryUtils.uploadSingleImage(request.getAvatar(), "account")));
            String emailContent = "Chào " + accountSave.getEmail() + "\n" + "Bạn vừa dùng email này để đăng ký tài khoản \n" + "Tài khoản của bạn là: " + accountSave.getUsername() + "\n" + "Mật khẩu đăng nhập là: " + accountSave.getPassword() + "\n\n" + "Đây là email tự động, vui lòng không trả lời email này.\nCảm ơn.\n\n" ;
            mailUtils.sendEmail(accountSave.getEmail(), "Thư xác thực tài khoản", emailContent);
        }
        return accountSave;
    }

    @Override
    public Account update(Long id, AccountRequest request) {
        Account old = accountRepository.findById(id).get();
        if (accountRepository.existsByUsernameAndUsernameNot(request.getUsername(), old.getUsername()))
            throw new NgoaiLe("Username đã tồn tại!");
        if (accountRepository.existsByEmailAndEmailNot(request.getEmail(), old.getEmail()))
            throw new NgoaiLe("Email đã tồn tại!");
        if (accountRepository.existsByPhoneNumberAndPhoneNumberNot(request.getPhoneNumber(), old.getPhoneNumber()))
            throw new NgoaiLe("SDT đã tồn tại!");
        if (accountRepository.existsByCccdAndCccdNot(request.getCccd(), old.getCccd()))
            throw new NgoaiLe("Mã định danh đã tồn tại!");
        Account accountSave = accountRepository.save(accountConvert.convertRequestToEntity(id, request));
        if (accountSave != null) {
            if (request.getAvatar() != null) {
                accountSave.setAvatar(String.valueOf(cloudinaryUtils.uploadSingleImage(request.getAvatar(), "account")));
                accountRepository.save(accountSave);
            }
        }
        return accountSave;
    }

    @Override
    public Account delete(Long id) {
        return null;
    }
}
