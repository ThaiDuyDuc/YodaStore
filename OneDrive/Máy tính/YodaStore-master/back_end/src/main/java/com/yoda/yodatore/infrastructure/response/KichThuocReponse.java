package com.yoda.yodatore.infrastructure.response;

import com.yoda.yodatore.entity.KichThuoc;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {KichThuoc.class})
public interface KichThuocReponse {
    Long getId();
    String getName();
}
