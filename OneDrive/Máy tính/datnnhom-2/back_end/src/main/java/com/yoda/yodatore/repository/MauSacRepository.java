package com.yoda.yodatore.repository;

import com.yoda.yodatore.entity.MauSac;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import com.yoda.yodatore.infrastructure.response.KichThuocResponse;
import com.yoda.yodatore.infrastructure.response.MauSacResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Long> {

    Boolean existsByNameIgnoreCase(String name);
    @Query(value = """
            SELECT
            c.id AS id,
            c.name AS name,
            c.create_at AS createAt,
            ROW_NUMBER() OVER(ORDER BY c.create_at DESC) AS indexs,
            c.deleted AS status
            FROM mau_sac c
            LEFT JOIN san_pham_chi_tiet sd ON c.id = sd.kich_thuoc_id
            WHERE (:#{#req.name} IS NULL OR c.name LIKE %:#{#req.name}%)
            AND (:#{#req.status} IS NULL OR c.deleted = :#{#req.status})
            GROUP BY c.id
            """, nativeQuery = true)
    Page<MauSacResponse> getAllMauSac(@Param("req") MauSacRequest request, Pageable pageable);
}
