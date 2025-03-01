package com.yoda.yodatore.infrastructure.response;


import com.yoda.yodatore.entity.ThuongHieu;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(types = {ThuongHieu.class})
public interface ThuongHieuResponse {
    @Value("#{target.indexs}")
    Integer getIndex();
    Long getId();
    String getName();
    Boolean getStatus();
    LocalDateTime getCreateAt();
}
