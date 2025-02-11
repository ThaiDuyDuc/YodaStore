package com.example.demo.repository;

import com.example.demo.entity.AccountVoucher;
import com.example.demo.infrastructure.response.AccountVoucherResponse;
import com.example.demo.infrastructure.response.VoucherResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountVoucherRepository extends JpaRepository<AccountVoucher, Long> {

    @Query("""
    SELECT b 
    FROM AccountVoucher b
""")
    Page<AccountVoucherResponse> getAll(Pageable pageable);

}
