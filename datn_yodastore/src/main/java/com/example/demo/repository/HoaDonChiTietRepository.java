package com.example.demo.repository;

import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.infrastructure.response.HoaDonChiTietResponse;
import com.example.demo.infrastructure.response.HoaDonResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Long> {

//    Boolean existsByCodeIgnoreCaseAndCodeNot(String code, String exceptCode);

    @Query("""
    SELECT b 
    FROM HoaDonChiTiet b
""")
    Page<HoaDonChiTietResponse> getAll(Pageable pageable);


}
