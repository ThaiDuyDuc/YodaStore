package com.example.demo.infrastructure.response;

import com.example.demo.entity.Account;
import com.example.demo.entity.Voucher;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Nationalized;

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
