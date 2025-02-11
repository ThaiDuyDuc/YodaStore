package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import com.example.demo.infrastructure.response.HoaDonResponse;
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
