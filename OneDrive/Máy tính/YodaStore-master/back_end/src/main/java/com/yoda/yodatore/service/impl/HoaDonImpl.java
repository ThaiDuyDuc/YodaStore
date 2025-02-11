package com.yoda.yodatore.service.impl;


import com.yoda.yodatore.entity.HoaDon;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.exception.NgoaiLe;
import com.yoda.yodatore.infrastructure.response.HoaDonResponse;
import com.yoda.yodatore.repository.HoaDonRepository;
import com.yoda.yodatore.service.HoaDonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HoaDonImpl implements HoaDonService {
        @Autowired
    private HoaDonRepository repository;


    public PhanTrang<HoaDonResponse> getAll(Integer page){
        return new PhanTrang<>(repository.getAll(PageRequest.of(page-1 ,5)));
    }
//
    public HoaDon getOne(Long id){
        return repository.findById(id).get();
    }
//
    public HoaDon add(HoaDon hoaDon){
        if (repository.existsByCodeIgnoreCaseAndCodeNot(hoaDon.getCode(),"")){
            throw new NgoaiLe("Thuộc tính" + hoaDon.getCode() + "đã tồn tại");
        }
        return repository.save(hoaDon);
    }
//
    public HoaDon update(Long id,HoaDon hoaDon){
        HoaDon hd = this.getOne(id);

        hd.setTienGiam(hoaDon.getTienGiam());
        hd.setTienVanChuyen(hoaDon.getTienVanChuyen());
        hd.setTrangThai(hoaDon.getTrangThai());
        hd.setTongTien(hoaDon.getTongTien());
        hd.setTienShip(hoaDon.getTienShip());
        hd.setLoai(hoaDon.getLoai());
        hd.setNgayMongMuon(hoaDon.getNgayMongMuon());
        hd.setNgayThanhToan(hoaDon.getNgayThanhToan());
        hd.setNgayNhan(hoaDon.getNgayNhan());
        hd.setShipDate(hoaDon.getShipDate());
        hd.setEmail(hoaDon.getEmail());
        hd.setSoDienThoai(hoaDon.getSoDienThoai());
        hd.setCode(hoaDon.getCode());
        hd.setDiaChi(hoaDon.getDiaChi());
        hd.setCustomerName(hoaDon.getCustomerName());
        hd.setGhiChu(hoaDon.getGhiChu());
        hd.setAccount(hoaDon.getAccount());
        hd.setCustomer(hoaDon.getCustomer());
        hd.setVoucher(hoaDon.getVoucher());
        return repository.save(hd);
    }


    public HoaDon delete(Long id) {
        Optional<HoaDon> hoaDon = repository.findById(id);
        if (hoaDon.isEmpty()) {
            throw new EntityNotFoundException("Không tìm thấy hóa đơn với ID: " + id);
        }
        repository.deleteById(id);
        return hoaDon.get();
    }



}
