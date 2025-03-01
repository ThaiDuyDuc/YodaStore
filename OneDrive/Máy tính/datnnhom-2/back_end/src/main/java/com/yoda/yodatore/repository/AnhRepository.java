package com.yoda.yodatore.repository;


import com.yoda.yodatore.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnhRepository extends JpaRepository<Images,Long> {
//    List<AnhReponse> findByAndDeletedFalse(Long idSanPhamChiTiet);

//    List<Anh> find(SanPham sanPham, MauSac mauSac);
}
