package com.yoda.yodatore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yoda.yodatore.entity.base.PrimaryEnity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "hoa_don_chi_tiet")
public class HoaDonChiTiet extends PrimaryEnity {

    @Column(name = "gia")
    private BigDecimal gia;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "trang_thai")
    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "hoa_don_id")
    @JsonIgnoreProperties(value = {"createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "san_pham_id")
    @JsonIgnoreProperties(value = { "createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private SanPham sanPham;
}