package com.yoda.yodatore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yoda.yodatore.entity.base.PrimaryEnity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "san_pham")
public class SanPham extends PrimaryEnity{
    @Nationalized
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "danh_muc_id")
    @JsonIgnoreProperties(value = {"createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private DanhMuc category;

    @ManyToOne
    @JoinColumn(name = "thuong_hieu_id")
    @JsonIgnoreProperties(value = {"createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private ThuongHieu brand;

    @ManyToOne
    @JoinColumn(name = "de_id")
    @JsonIgnoreProperties(value = {"creatAt","updateAt","createBy","updateBy","deleted"})
    private De sole;

    @JsonIgnore
    @OneToMany(mappedBy = "shoe")
    List<SanPhamChiTiet> SanPhamChiTiet;

    @Column(name = "mo_ta")
    private String description;

}
