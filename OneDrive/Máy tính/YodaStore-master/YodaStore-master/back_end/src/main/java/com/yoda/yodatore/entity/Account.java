package com.yoda.yodatore.entity;

import com.yoda.yodatore.entity.base.PrimaryEnity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "account")
public class Account extends PrimaryEnity {

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "vai_tro_tai_khoan")
    private RoleEnum vaiTroTaiKhoan;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "cccd")
    private String cccd;

    @Column(name = "email")
    private String email;

    @Nationalized
    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Nationalized
    @Column(name = "ten")
    private String ten;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "username")
    private String username;

}