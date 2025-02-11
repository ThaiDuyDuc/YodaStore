package com.yoda.yodatore.infrastructure.response;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface VoucherResponse {

     BigDecimal getGiaTriToiThieu();

     Float hanTramGiamgetP();

     Integer getSoLuong();

     Integer getTrangThai();

     Boolean getLoai();

     LocalDateTime getNgayBatDau();

     LocalDateTime getNgayKetThuc();

     String getCode();

     String getName();
}
