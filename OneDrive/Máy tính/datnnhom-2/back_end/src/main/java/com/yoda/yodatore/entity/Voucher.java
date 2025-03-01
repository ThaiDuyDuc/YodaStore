package com.yoda.yodatore.entity;

import com.yoda.yodatore.entity.base.PrimaryEnity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "voucher")

public class Voucher extends PrimaryEnity {
    @Column(name = "code", unique = true, length = 20)
    private String code;

    @Nationalized
    @Column(name = "name", length = 50)
    private String name;
    @Nationalized
    @Column(name = "so_luong")
    private Integer quantity;
    @Nationalized
    @Column(name = "phan_tram_giam")
    private Float percentReduce;
    @Nationalized
    @Column(name = "gia_tri_toi_thieu")
    private BigDecimal minBillValue;
    @Column(name = "gia_tri_toi_da")
    private BigDecimal maxBillValue;
    @Nationalized
    @Column(name = "ngay_bat_dau")
    private LocalDateTime startDate;
    @Nationalized
    @Column(name = "ngay_ket_thuc")
    private LocalDateTime endDate;
    @Nationalized
    @Column(name = "status")
    private Integer status;
}
