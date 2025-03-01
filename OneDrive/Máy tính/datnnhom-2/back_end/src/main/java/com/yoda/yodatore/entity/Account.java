package com.yoda.yodatore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yoda.yodatore.entity.base.PrimaryEnity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

@Entity
@Table(name = "account")
public class Account extends PrimaryEnity {
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "cccd")
    private String cccd;
    @Nationalized
    @Column(name = "name")
    private String name;
    @Column(name = "so_dien_thoai", unique = true)
    private String phoneNumber;
    @Column(name = "email", unique = true)
    private String email;
    @Nationalized
    @Column(name = "password")
    private String password;
    @Nationalized
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "ngay_sinh")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Nationalized
    @Column(name = "gioi_tinh")
    private String gender;
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties(value = {"createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private Role role;

    @JsonIgnoreProperties(value = {"shoeDetail", "createAt", "updateAt", "createBy", "updateBy", "deleted"})
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    List<Address> addresses;
}
