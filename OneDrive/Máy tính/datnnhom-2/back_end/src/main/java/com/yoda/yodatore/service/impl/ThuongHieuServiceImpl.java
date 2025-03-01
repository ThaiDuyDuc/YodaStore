package com.yoda.yodatore.service.impl;

import com.yoda.yodatore.entity.De;
import com.yoda.yodatore.entity.KichThuoc;
import com.yoda.yodatore.entity.ThuongHieu;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.converter.ThuongHieuConvert;
import com.yoda.yodatore.infrastructure.exception.NgoaiLe;
import com.yoda.yodatore.infrastructure.request.DeRequest;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import com.yoda.yodatore.infrastructure.request.ThuongHieuRequest;
import com.yoda.yodatore.infrastructure.response.KichThuocResponse;

import com.yoda.yodatore.infrastructure.response.MauSacResponse;
import com.yoda.yodatore.infrastructure.response.ThuongHieuResponse;
import com.yoda.yodatore.repository.ThuongHieuRepository;
import com.yoda.yodatore.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    private ThuongHieuRepository repository;

    @Autowired
    private ThuongHieuConvert thuongHieuConvert;

    public PhanTrang<ThuongHieuResponse> getAll(ThuongHieuRequest request) {
        return new PhanTrang<>(repository.getAllThuongHieu(request, PageRequest.of(request.getPage() - 1, 5)));
    }


    public ThuongHieu getOne(Long id) {
        return repository.findById(id).get();
    }


    public ThuongHieu add(ThuongHieuRequest request) {
        if (repository.existsByNameIgnoreCase(request.getName())) {
            throw new NgoaiLe("Thương hiệu " + request.getName() + " đã tồn tại!");
        }
        ThuongHieu thuongHieu = thuongHieuConvert.addconvertRequest(request);
        return repository.save(thuongHieu);
    }

    public ThuongHieu update(Long id, ThuongHieuRequest request) {
        ThuongHieu name = repository.findById(id).get();
        if (repository.existsByNameIgnoreCase(request.getName())) {
            if (name.getName().equals(request.getName())){
                return repository.save(thuongHieuConvert.convertRequestToEntity(name,request));
            }
            throw new NgoaiLe("Thương hiệu " + request.getName() + " đã tồn tại!");
        }
        else {
            return repository.save(thuongHieuConvert.convertRequestToEntity(name,request));
        }


    }

    public ThuongHieu delete(Long id) {
        ThuongHieu thuongHieu = this.getOne(id);
        thuongHieu.setDeleted(!thuongHieu.getDeleted());
        return repository.save(thuongHieu);
    }


}
