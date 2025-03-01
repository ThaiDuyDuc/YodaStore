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

@Entity
@Table(name = "images")
public class Images extends PrimaryEnity {
    @ManyToOne
    @JoinColumn(name = "san_pham_chi_tiet_id")
    @JsonIgnore
    private SanPhamChiTiet sanPhamChiTiet;
    @Nationalized
    @Column(name = "name")
    private String name;
}
