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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "lich_su_hoa_don")
public class LichSuHoaDon extends PrimaryEnity {

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Nationalized
    @Column(name = "ghi_chu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "hoa_don_id")
    @JsonIgnoreProperties(value = { "createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private HoaDon hoaDon;
}
