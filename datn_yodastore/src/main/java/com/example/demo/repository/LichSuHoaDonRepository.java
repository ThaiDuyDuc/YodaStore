package com.example.demo.repository;

import com.example.demo.entity.LichSuHoaDon;
import com.example.demo.infrastructure.response.HoaDonChiTietResponse;
import com.example.demo.infrastructure.response.LichSuHoaDonReponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LichSuHoaDonRepository extends JpaRepository<LichSuHoaDon, Long> {

    @Query("""
    SELECT b 
    FROM LichSuHoaDon b
""")
    Page<LichSuHoaDonReponse> getAll(Pageable pageable);

}
