package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KichThuocRepository { //extends JpaRepository<KichThuoc,Long> {
//
//    Boolean existsByNameIgnoreCaseAndNameNot(String name, String exceptName);
//
//    @Query("""
//            SELECT b.id as id,b.name as name FROM KichThuoc b
//            WHERE (:name IS NULL OR b.name LIKE %:name%)
//            AND (:status IS NULL OR b.deleted = :status)
//            ORDER BY b.createAt
//            """)
//    Page<KichThuocReponse> getAll(@Param("name") String name, @Param("status") Boolean status, Pageable pageable);
}
