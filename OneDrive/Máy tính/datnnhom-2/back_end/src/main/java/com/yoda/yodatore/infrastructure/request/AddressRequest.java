package com.yoda.yodatore.infrastructure.request;

import lombok.Getter;
import lombok.Setter;
import com.yoda.yodatore.infrastructure.common.PageableRequest;
@Getter
@Setter
public class AddressRequest extends PageableRequest {
    private Long account;
    private String name;
    private String phoneNumber;
    private String specificAddress;
    private String ward;
    private String district;
    private String province;
    private Boolean defaultAddress;
    private Boolean status;
}
