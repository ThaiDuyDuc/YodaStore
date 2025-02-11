package com.yoda.yodatore.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yoda.yodatore.entity.base.PrimaryEnity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "account_voucher")
public class AccountVoucher extends PrimaryEnity {

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties(value = {"createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private Account account;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    @JsonIgnoreProperties(value = {"createAt", "updateAt", "createBy", "updateBy", "deleted"})
    private Voucher voucher;
}
