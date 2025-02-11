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
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "hoa_don")
public class HoaDon extends PrimaryEnity {

    @Column(name = "tien_giam")
    private BigDecimal tienGiam;

    @Column(name = "tien_van_chuyen")
    private BigDecimal tienVanChuyen;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "tong_tien")
    private BigDecimal tongTien;

    @Column(name = "tien_ship")
    private BigDecimal tienShip;

    @Column(name = "loai")
    private Integer loai;

    @Column(name = "ngay_mong_muon")
    private LocalDateTime ngayMongMuon;

    @Column(name = "ngay_thanh_toan")
    private LocalDateTime ngayThanhToan;

    @Column(name = "ngay_nhan")
    private LocalDateTime ngayNhan;

    @Column(name = "ship_date")
    private LocalDateTime shipDate;

    @Column(name = "email")
    private String email;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "customer_name")
    private String customerName;

    @Nationalized
    @Column(name = "ghi_chu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties({ "createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private Account account;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties({ "createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private Account customer;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    @JsonIgnoreProperties({ "createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private Voucher voucher;
}
