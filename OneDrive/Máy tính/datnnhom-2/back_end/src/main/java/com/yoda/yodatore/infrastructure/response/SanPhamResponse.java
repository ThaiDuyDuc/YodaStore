package com.yoda.yodatore.infrastructure.response;


import com.yoda.yodatore.entity.SanPham;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(types = {SanPham.class})
public interface SanPhamResponse {
    @Value("#{target.indexs}")
    Integer getIndex();

    Long getId();

    String getName();

    String getSize();

    String getColor();

    String getBrand();

    String getCategory();
    String getSole();

    Integer getQuantity();

    Boolean getStatus();
    BigDecimal getMaxPrice();
    BigDecimal getMinPrice();
    String getDescription();
    String getImages();

}
