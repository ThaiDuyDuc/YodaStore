package com.yoda.yodatore.infrastructure.converter;

import com.yoda.yodatore.entity.Address;
import com.yoda.yodatore.infrastructure.request.AddressRequest;
import com.yoda.yodatore.repository.AccountRepository;
import com.yoda.yodatore.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressConvert {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AccountRepository accountRepository;
    public Address convertRequestToEntity(AddressRequest request) {
        return Address.builder()
                .account(request.getAccount() != null ? accountRepository.findById(request.getAccount()).orElse(null) : null)
                .name(request.getName())
                .defaultAddress(false)
                .ward(request.getWard())
                .district(request.getDistrict())
                .province(request.getProvince())
                .phoneNumber(request.getPhoneNumber())
                .specificAddress(request.getSpecificAddress())
                .build();
    }
    public Address convertRequestToEntity(Long id, AddressRequest request){
        Address address = addressRepository.findById(id).get();
        address.setSpecificAddress(request.getSpecificAddress());
        address.setDefaultAddress(request.getDefaultAddress());
        address.setName(request.getName());
        address.setWard(request.getWard());
        address.setDistrict(request.getDistrict());
        address.setProvince(request.getProvince());
        address.setPhoneNumber(request.getPhoneNumber());
        return address;
    }
}
