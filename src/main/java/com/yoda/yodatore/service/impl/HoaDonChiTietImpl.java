package com.yoda.yodatore.service.impl;


import com.yoda.yodatore.entity.HoaDonChiTiet;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.response.HoaDonChiTietResponse;
import com.yoda.yodatore.repository.HoaDonChiTietRepository;
import com.yoda.yodatore.service.HoaDonChiTietService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HoaDonChiTietImpl implements HoaDonChiTietService {

    @Autowired
    private HoaDonChiTietRepository repository;

    @Override
    public PhanTrang<HoaDonChiTietResponse> getAll(Integer page) {
// Đảm bảo page >= 0
        if (page < 1) {
            page = 1; // Đặt về trang đầu tiên nếu page < 1
        }

        return new PhanTrang<>(repository.getAll(PageRequest.of(page - 1, 5)));
    }

    @Override
    public HoaDonChiTiet getOne(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet) {
        return repository.save(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet update(Long id, HoaDonChiTiet hoaDonChiTiet) {

        HoaDonChiTiet hoaDonChiTiet1 = this.getOne(id);

        hoaDonChiTiet1.setGia(hoaDonChiTiet.getGia());
        hoaDonChiTiet1.setSoLuong(hoaDonChiTiet.getSoLuong());
        hoaDonChiTiet1.setTrangThai(hoaDonChiTiet.getTrangThai());
        hoaDonChiTiet1.setHoaDon(hoaDonChiTiet.getHoaDon());
        hoaDonChiTiet1.setSanPham(hoaDonChiTiet.getSanPham());

        return repository.save(hoaDonChiTiet1);
    }

    @Override
    public HoaDonChiTiet delete(Long id) {
        Optional<HoaDonChiTiet> hoaDonChiTiet = repository.findById(id);
        if(hoaDonChiTiet.isEmpty()){
            throw new EntityNotFoundException("Không tìm thấy hóa đơn có ID: " + id);
        }
        repository.deleteById(id);

        return hoaDonChiTiet.get();
    }

}
