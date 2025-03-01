package com.yoda.yodatore.repository;

import com.yoda.yodatore.entity.ThuongHieu;
import com.yoda.yodatore.infrastructure.request.KichThuocRequest;
import com.yoda.yodatore.infrastructure.request.ThuongHieuRequest;
import com.yoda.yodatore.infrastructure.response.KichThuocResponse;
import com.yoda.yodatore.infrastructure.response.ThuongHieuResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu,Long> {
    Boolean existsByNameIgnoreCase(String name);

    @Query(value = """
            SELECT
            s.id AS id,
            s.name AS name,
            s.create_at AS createAt,
            ROW_NUMBER() OVER(ORDER BY s.create_at DESC) AS indexs,
            s.deleted AS status
            FROM thuong_hieu s
            LEFT JOIN san_pham_chi_tiet sd ON s.id = sd.kich_thuoc_id
            WHERE (:#{#req.name} IS NULL OR s.name LIKE %:#{#req.name}%)
            AND (:#{#req.status} IS NULL OR s.deleted = :#{#req.status})
            GROUP BY s.id
            """, nativeQuery = true)
    Page<ThuongHieuResponse> getAllThuongHieu(@Param("req") ThuongHieuRequest request, Pageable pageable);
}
