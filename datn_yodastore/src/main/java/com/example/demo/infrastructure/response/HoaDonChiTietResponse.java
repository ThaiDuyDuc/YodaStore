package com.example.demo.infrastructure.response;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.SanPham;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public interface HoaDonChiTietResponse {

     BigDecimal getGia();

     Integer getSoLuong();

     Boolean getTrangThai();

     HoaDon getHoaDon();

     SanPham getSanPham();

}
