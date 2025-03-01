package com.yoda.yodatore.service.impl;

import com.yoda.yodatore.entity.DanhMuc;
import com.yoda.yodatore.entity.MauSac;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.converter.DanhMucConvert;
import com.yoda.yodatore.infrastructure.exception.NgoaiLe;
import com.yoda.yodatore.infrastructure.request.DanhMucRequest;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import com.yoda.yodatore.infrastructure.response.DanhMucResponse;
import com.yoda.yodatore.infrastructure.response.DeResponse;
import com.yoda.yodatore.infrastructure.response.KichThuocResponse;
import com.yoda.yodatore.repository.DanhMucRepository;
import com.yoda.yodatore.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DanhMucServieImpl implements DanhMucService {
    @Autowired
    private DanhMucRepository repository;


    @Autowired
    private DanhMucConvert danhMucConvert;

    public PhanTrang<DanhMucResponse> getAll(DanhMucRequest request) {
        return new PhanTrang<>(repository.getAllDanhMuc(request, PageRequest.of(request.getPage() - 1, 5)));
    }


    public DanhMuc getOne(Long id) {
        return repository.findById(id).get();
    }


    public DanhMuc add(DanhMucRequest request) {
        if (repository.existsByNameIgnoreCase(request.getName())) {
            throw new NgoaiLe("Danh Mục " + request.getName() + " đã tồn tại!");
        }
        DanhMuc danhMuc = danhMucConvert.addconvertRequest(request);
        return repository.save(danhMuc);
    }



    public DanhMuc update(Long id, DanhMucRequest request) {
        DanhMuc name = repository.findById(id).get();
        if (repository.existsByNameIgnoreCase(request.getName())) {
            if (name.getName().equals(request.getName())){
                return repository.save(danhMucConvert.convertRequestToEntity(name,request));
            }
            throw new NgoaiLe("Danh mục " + request.getName() + " đã tồn tại!");
        }
        else {
            return repository.save(danhMucConvert.convertRequestToEntity(name,request));
        }

    }


    public DanhMuc delete(Long id) {
        DanhMuc danhMuc = this.getOne(id);
        danhMuc.setDeleted(!danhMuc.getDeleted());
        return repository.save(danhMuc);
    }
}
