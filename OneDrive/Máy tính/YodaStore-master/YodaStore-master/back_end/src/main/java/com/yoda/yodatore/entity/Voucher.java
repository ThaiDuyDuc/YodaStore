package com.yoda.yodatore.entity;

import com.yoda.yodatore.entity.base.PrimaryEnity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "voucher", uniqueConstraints = @UniqueConstraint(columnNames = "code")) // đảm bảo cột code không có giá trị giống nhau
public class Voucher extends PrimaryEnity {

    @Column(name = "gia_tri_toi_thieu", precision = 38, scale = 2)
    private BigDecimal giaTriToiThieu;

    @Column(name = "phan_tram_giam")
    private Float phanTramGiam;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "loai")
    private Boolean loai;

    @Column(name = "ngay_bat_dau")
    private LocalDateTime ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private LocalDateTime ngayKetThuc;

    @Column(name = "code", length = 20, unique = true)
    private String code;

    @Column(name = "name", length = 50)
    private String name;
}