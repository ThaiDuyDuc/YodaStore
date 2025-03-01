package com.yoda.yodatore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yoda.yodatore.entity.base.PrimaryEnity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name = "san_pham_chi_tiet")
public class SanPhamChiTiet extends PrimaryEnity {

    @Column(name = "code" , length = 50)
    private String code;
    @Column(name = "gia")
    private BigDecimal price;
    @Column(name = "so_luong")
    private Integer quantity;
    @Column(name = "can_nang")
    private Double weight;



    @ManyToOne
    @JoinColumn(name = "san_pham_id")
    @JsonIgnoreProperties(value = {"creatAt","updateAt","createBy","updateBy","deleted"})
    private SanPham shoe;

    @ManyToOne
    @JoinColumn(name = "kich_thuoc_id")
    @JsonIgnoreProperties(value = {"creatAt","updateAt","createBy","updateBy","deleted"})
    private KichThuoc size;



    @ManyToOne
    @JoinColumn(name = "mau_sac_id")
    @JsonIgnoreProperties(value = {"creatAt","updateAt","createBy","updateBy","deleted"})
    private MauSac color;

    @JsonIgnoreProperties(value = {"sanPhamChiTiet", "createAt", "updateAt", "createBy", "updateBy", "deleted"})
    @OneToMany(mappedBy = "sanPhamChiTiet", fetch = FetchType.LAZY)
    private List<Images> images;
}
