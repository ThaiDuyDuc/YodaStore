package com.yoda.yodatore.repository;

import com.yoda.yodatore.entity.SanPhamChiTiet;
import com.yoda.yodatore.infrastructure.request.SanPhamChiTietRequest;
import com.yoda.yodatore.infrastructure.response.SanPhamChiTietReponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet,Long> {
    SanPhamChiTiet findByCode(String code);

    @Query(value = """
            SELECT sd.id AS id,
            ROW_NUMBER() OVER(ORDER BY s.create_at DESC) AS indexs,
            CONCAT(s.name, ' [', c.name, ' - ', sz.name, ']') AS name,
            sd.code AS code,
            sl.name AS sole,
            c.name AS color,
            sz.name AS size,
            sd.so_luong AS quantity,
            sd.can_nang AS weight,
            sd.gia AS price,
            GROUP_CONCAT(DISTINCT img.name) AS images,
            sd.deleted AS status
            FROM san_pham_chi_tiet sd
            JOIN san_pham s ON sd.san_pham_id = s.id
            JOIN mau_sac c ON sd.mau_sac_id = c.id
            JOIN kich_thuoc sz ON sd.kich_thuoc_id = sz.id
            JOIN de sl ON sd.de_id = sl.id
            JOIN images img ON img.san_pham_chi_tiet_id = sd.id
            WHERE (:#{#req.shoe} IS NULL OR sd.san_pham_id = :#{#req.shoe})
            AND (:#{#req.color} IS NULL OR sd.mau_sac_id = :#{#req.color})
            AND (:#{#req.size} IS NULL OR sd.kich_thuoc_id = :#{#req.size})
            AND (:#{#req.sole} IS NULL OR sd.de_id = :#{#req.sole})
            AND (:#{#req.name} IS NULL OR CONCAT(s.name, ' ', c.name, ' ', sz.name, ' ') LIKE %:#{#req.name}%)
            GROUP BY sd.id
            """, nativeQuery = true)
    Page<SanPhamChiTietReponse> getAll(@Param("req") SanPhamChiTietRequest request, Pageable pageable);

    SanPhamChiTiet findByShoeIdAndColorIdAndSizeId(Long idShoe, Long idColor, Long idSize);

    SanPhamChiTiet findByShoeIdAndColorNameAndSizeName(Long idShoe, String colorName, String sizeNmae);
}