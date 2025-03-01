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
@Builder
@Entity
@Table(name = "mau_sac")


public class MauSac extends PrimaryEnity {

    @Nationalized
    @Column(name = "name")
    @NotNull(message = "Tên không được để trống")
    private String name;
}
