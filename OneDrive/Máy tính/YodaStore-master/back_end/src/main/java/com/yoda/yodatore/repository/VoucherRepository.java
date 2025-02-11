package com.yoda.yodatore.repository;

import com.yoda.yodatore.entity.Voucher;
import com.yoda.yodatore.infrastructure.response.VoucherResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    @Query("""
    SELECT b 
    FROM Voucher b
""")
    Page<VoucherResponse> getAll(Pageable pageable);

}
