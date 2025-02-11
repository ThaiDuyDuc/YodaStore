package com.yoda.yodatore.infrastructure.response;



import com.yoda.yodatore.entity.Account;
import com.yoda.yodatore.entity.Voucher;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface HoaDonResponse {

     BigDecimal getTienGiam();

     BigDecimal getTienVanChuyen();

     Integer getTrangThai();

     BigDecimal getTongTien();

     BigDecimal getTienShip();

     Integer getLoai();

     LocalDateTime getNgayMongMuon();

     LocalDateTime getNgayThanhToan();

     LocalDateTime getNgayNhan();

     LocalDateTime getShipDate();

     String getEmail();

     String getSoDienThoai();

     String getDiaChi();

     String getCode();

     String getCustomerName();

     String getGhiChu();

     Account getAccount();

     Account getCustomer();

     Voucher getVoucher();
}
