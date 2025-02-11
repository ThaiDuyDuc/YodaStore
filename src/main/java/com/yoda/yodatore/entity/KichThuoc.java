package com.yoda.yodatore.entity;

import com.yoda.yodatore.entity.base.PrimaryEnity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "kich_thuoc")

public class KichThuoc extends PrimaryEnity {
    @Nationalized
    @Column(name = "name")
    @NotNull(message = "Tên không được bỏ trống")
    private String name;
}
