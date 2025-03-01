package com.yoda.yodatore.infrastructure.response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import com.yoda.yodatore.entity.SanPhamChiTiet;
import java.math.BigDecimal;
@Projection(types = {SanPhamChiTiet.class})
public interface SanPhamChiTietReponse {
    Long getId();
    @Value("#{target.indexs}")
    Integer getIndex();

    String getCode();
    String getName();

    String getSole();

    String getColor();

    String getSize();

    Integer getQuantity();

    BigDecimal getPrice();

    Double getWeight();

    String getImages();
    Boolean getStatus();

}
