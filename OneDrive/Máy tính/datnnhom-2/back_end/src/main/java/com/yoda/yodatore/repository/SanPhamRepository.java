package com.yoda.yodatore.repository;

import com.yoda.yodatore.entity.SanPham;
import com.yoda.yodatore.infrastructure.request.SanPhamRequest;
import com.yoda.yodatore.infrastructure.response.SanPhamResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
    Boolean existsByNameIgnoreCase(String name);

    @Query(value = """
            SELECT
            s.id AS id,s.name AS name,
            ROW_NUMBER() OVER(ORDER BY s.create_at DESC) AS indexs,
            GROUP_CONCAT(DISTINCT (CONCAT('{ \"id\": \"', c.id, '\",\"name\": \"', c.name, '\"}'))) AS color,
            GROUP_CONCAT(DISTINCT (CONCAT('{ \"id\": \"', sz.id, '\",\"name\": \"', sz.name, '\"}'))) AS size,
            GROUP_CONCAT(DISTINCT img.name) AS images,
            s.mo_ta AS description,
            SUM(sd.so_luong) AS quantity,
            ct.name AS category,
            br.name AS brand,
            MAX(sd.gia) AS maxPrice,
            MIN(sd.gia) AS minPrice,
            s.deleted AS status
            FROM san_pham s
            LEFT JOIN san_pham_chi_tiet sd ON s.id = sd.san_pham_id
            LEFT JOIN mau_sac c ON c.id = sd.mau_sac_id
            LEFT JOIN kich_thuoc sz ON sz.id = sd.kich_thuoc_id
            LEFT JOIN danh_muc ct ON ct.id = s.danh_muc_id
            LEFT JOIN thuong_hieu br ON br.id = s.thuong_hieu_id
            LEFT JOIN (SELECT san_pham_chi_tiet_id, 
            GROUP_CONCAT(DISTINCT name) AS name FROM images GROUP BY san_pham_chi_tiet_id
            ) img ON sd.id = img.san_pham_chi_tiet_id
            WHERE (:#{#req.name} IS NULL OR s.name LIKE %:#{#req.name}%)
            AND (:#{#req.brand} IS NULL OR s.thuong_hieu_id = :#{#req.brand})
            AND (:#{#req.category} IS NULL OR s.danh_muc_id = :#{#req.category})
            AND (:#{#req.status} IS NULL OR s.deleted = :#{#req.status})
            GROUP BY s.id
            """, nativeQuery = true)
    Page<SanPhamResponse> getAllShoe(@Param("req") SanPhamRequest request, Pageable pageable);
}
