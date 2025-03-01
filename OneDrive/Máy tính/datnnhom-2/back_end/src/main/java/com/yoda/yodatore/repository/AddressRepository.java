package com.yoda.yodatore.repository;

import com.yoda.yodatore.entity.Address;
import com.yoda.yodatore.infrastructure.request.AddressRequest;
import com.yoda.yodatore.infrastructure.response.AddressResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByAccountIdAndDeleted(Long id, Boolean deleted);

    Page<Address> findByAccountIdAndDeleted(Long id, Boolean deleted, Pageable pageable);

    Address findByAccountIdAndDefaultAddress(Long id, Boolean defaultAddress);

    @Query(value = """
            SELECT
            a.id AS id,
            a.name AS name,
            a.sdt AS phoneNumber,
            a.phuong_xa AS ward,
            a.quan_huyen AS district,
            a.tinh_thanh_pho AS province,
            a.dia_chi_cu_the AS specificAddress,
            a.dia_chi_mac_dinh AS defaultAddress,
            ROW_NUMBER() OVER(ORDER BY a.create_at DESC) AS indexs,
            a.deleted AS status
            FROM dia_chi a 
            LEFT JOIN account ac on ac.id = a.account_id
            WHERE (:#{#req.account} IS NULL OR a.account_id = :#{#req.account})
            AND (:#{#req.status} IS NULL OR a.deleted = :#{#req.status})
            GROUP BY a.id
            """, nativeQuery = true)
    Page<AddressResponse> getAddress(@Param("req") AddressRequest request, Pageable pageable);
}
