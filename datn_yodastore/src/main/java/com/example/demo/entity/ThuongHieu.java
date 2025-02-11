package com.example.demo.entity;

import com.example.demo.entity.base.PrimaryEnity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "thuong_hieu")
public class ThuongHieu extends PrimaryEnity {

    @Nationalized
    @Column(name = "name")
    private String name;

}
