package com.yoda.yodatore.service.impl;

import com.yoda.yodatore.entity.Address;
import com.yoda.yodatore.infrastructure.converter.AddressConvert;
import com.yoda.yodatore.infrastructure.exception.NgoaiLe;
import com.yoda.yodatore.infrastructure.request.AddressRequest;
import com.yoda.yodatore.infrastructure.response.AddressResponse;
import com.yoda.yodatore.repository.AddressRepository;
import com.yoda.yodatore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressConvert addressConvert;

    @Override
    public Page<AddressResponse> getByAccount(AddressRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSizePage());
        return addressRepository.getAddress(request, pageable);
    }

    @Override
    public Address create(AddressRequest request) {
        return addressRepository.save(addressConvert.convertRequestToEntity(request));
    }

    @Override
    public Address update(Long idAddress, AddressRequest request) {
        Address addressUpdate = addressConvert.convertRequestToEntity(idAddress, request);
        if (request.getDefaultAddress()) {
            Address addressDefault = addressRepository.findByAccountIdAndDefaultAddress(addressUpdate.getAccount().getId(), true);
            if (addressDefault != null) {
                addressDefault.setDefaultAddress(false);
                addressRepository.save(addressDefault);
            }
        }
        return addressRepository.save(addressUpdate);
    }

    @Override
    public Address delete(Long idAddress) {
        Address address = addressRepository.findById(idAddress).get();

        if (addressRepository.findByAccountIdAndDeleted(address.getAccount().getId(), false).size() > 1) {
            address.setDeleted(true);
            return addressRepository.save(address);
        } else {
            throw new NgoaiLe("Không thể xóa địa chỉ này!");
        }
    }
}
