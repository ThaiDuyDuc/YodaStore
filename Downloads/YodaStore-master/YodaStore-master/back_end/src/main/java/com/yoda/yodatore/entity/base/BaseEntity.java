package com.yoda.yodatore.entity.base;


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
    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    @CreatedBy
    @Column(name = "create_by")
    private String createBy;
    @LastModifiedBy
    @Column(name = "update_by")
    private String updateBy;
    @Column(name = "deleted")
    private Boolean deleted;

    @PrePersist
    public void prePersist(){
        createAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
        createBy = "Luu Van Nam";
        updateBy = "Luu Van Nam";

    }
    @PreUpdate
    public void preUpdate(){
        updateAt = LocalDateTime.now();
        updateBy = "aa";
    }

}
