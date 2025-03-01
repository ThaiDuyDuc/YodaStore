package com.yoda.yodatore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yoda.yodatore.entity.base.PrimaryEnity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

@Entity
@Table(name = "dia_chi")
public class Address extends PrimaryEnity {
    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;
    @Nationalized
    @Column(name = "name")
    private String name;
    @Column(name = "sdt", length = 20)
    private String phoneNumber;
    @Nationalized
    @Column(name = "dia_chi_cu_the")
    private String specificAddress;
    @Nationalized
    @Column(name = "phuong_xa")
    private String ward;
    @Nationalized
    @Column(name = "quan_huyen")
    private String district;
    @Nationalized
    @Column(name = "tinh_thanh_pho")
    private String province;
    @Column(name = "dia_chi_mac_dinh")
    private Boolean defaultAddress;
}
