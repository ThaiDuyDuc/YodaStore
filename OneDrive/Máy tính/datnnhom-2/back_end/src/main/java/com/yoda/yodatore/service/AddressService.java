package com.yoda.yodatore.service;

import com.yoda.yodatore.entity.Address;
import com.yoda.yodatore.infrastructure.request.AddressRequest;
import com.yoda.yodatore.infrastructure.response.AddressResponse;
import org.springframework.data.domain.Page;

public interface AddressService {
    Page<AddressResponse> getByAccount(AddressRequest request);

    Address create(AddressRequest request);

    Address update(Long idAddress, AddressRequest request);

    Address delete(Long idAddress);
}
