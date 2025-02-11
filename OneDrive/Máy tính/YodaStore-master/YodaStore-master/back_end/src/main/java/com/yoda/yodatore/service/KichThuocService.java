package com.yoda.yodatore.service;

import com.yoda.yodatore.entity.KichThuoc;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.response.KichThuocReponse;

public interface KichThuocService  {

    PhanTrang<KichThuocReponse> getAll(String name, Integer page, Boolean status);

    KichThuoc getOne(Long id);
    KichThuoc add(KichThuoc kichThuoc);
    KichThuoc update(Long id, KichThuoc kichThuoc);
    KichThuoc delete(Long id);

}
