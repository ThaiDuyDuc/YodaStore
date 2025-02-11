package com.yoda.yodatore.repository;


import com.yoda.yodatore.entity.HoaDon;
import com.yoda.yodatore.infrastructure.response.HoaDonResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

    Boolean existsByCodeIgnoreCaseAndCodeNot(String code, String exceptCode);

    @Query("""
    SELECT b 
    FROM HoaDon b
""")
    Page<HoaDonResponse> getAll(Pageable pageable);

}
