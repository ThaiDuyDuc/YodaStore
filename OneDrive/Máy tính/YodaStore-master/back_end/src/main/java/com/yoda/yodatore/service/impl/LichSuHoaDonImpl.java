package com.yoda.yodatore.service.impl;


import com.yoda.yodatore.entity.LichSuHoaDon;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.response.LichSuHoaDonReponse;
import com.yoda.yodatore.repository.LichSuHoaDonRepository;
import com.yoda.yodatore.service.LichSuHoaDonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LichSuHoaDonImpl implements LichSuHoaDonService {

    @Autowired
    private LichSuHoaDonRepository repository;

    @Override
    public PhanTrang<LichSuHoaDonReponse> getAll(Integer page) {

        return new PhanTrang<>(repository.getAll(PageRequest.of(page - 1, 5)));
    }

    @Override
    public LichSuHoaDon getOne(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public LichSuHoaDon add(LichSuHoaDon lichSuHoaDon) {
        return repository.save(lichSuHoaDon);
    }

    @Override
    public LichSuHoaDon update(Long id, LichSuHoaDon lichSuHoaDon) {
        LichSuHoaDon lichSuHoaDon1 = this.getOne(id);

        lichSuHoaDon1.setTrangThai(lichSuHoaDon.getTrangThai());
        lichSuHoaDon1.setGhiChu(lichSuHoaDon.getGhiChu());
        lichSuHoaDon1.setHoaDon(lichSuHoaDon.getHoaDon());

        return repository.save(lichSuHoaDon1);
    }

    @Override
    public LichSuHoaDon delete(Long id) {
        Optional<LichSuHoaDon> lichSuHoaDon = repository.findById(id);
        if(lichSuHoaDon.isEmpty()){
            throw new EntityNotFoundException("Không tìm thấy lịch sử hóa đơn có ID: " + id);
        }
        repository.deleteById(id);

        return lichSuHoaDon.get();
    }
}
