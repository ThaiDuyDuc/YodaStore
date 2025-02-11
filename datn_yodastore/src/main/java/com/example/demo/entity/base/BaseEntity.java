package com.example.demo.entity.base;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    // thời gian tạo
    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createAt;

    // thời gian cập nhật
    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    // người tạo
    @CreatedBy
    @Column(name = "create_by")
    private String createBy;

    // người cập nhật
    @LastModifiedBy
    @Column(name = "update_by")
    private String updateBy;

    // xóa
    @Column(name = "deleted")
    private Boolean deleted;

    @PrePersist
    public void prePersist(){
        createAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
        createBy = "Nguyen Van A";
        updateBy = "Nguyen Van A";

    }
    @PreUpdate
    public void preUpdate(){
        updateAt = LocalDateTime.now();
        updateBy = "Le Thi C";
    }

}
