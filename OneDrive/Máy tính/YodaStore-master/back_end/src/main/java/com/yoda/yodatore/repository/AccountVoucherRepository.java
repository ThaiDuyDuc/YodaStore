package com.yoda.yodatore.repository;


import com.yoda.yodatore.entity.AccountVoucher;
import com.yoda.yodatore.infrastructure.response.AccountVoucherResponse;
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
