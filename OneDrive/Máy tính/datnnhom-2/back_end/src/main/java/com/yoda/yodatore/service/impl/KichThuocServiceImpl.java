package com.yoda.yodatore.service.impl;

import com.yoda.yodatore.entity.KichThuoc;
import com.yoda.yodatore.entity.MauSac;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.converter.KichThuocConvert;
import com.yoda.yodatore.infrastructure.exception.NgoaiLe;
import com.yoda.yodatore.infrastructure.request.KichThuocRequest;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import com.yoda.yodatore.infrastructure.response.KichThuocResponse;
import com.yoda.yodatore.infrastructure.response.MauSacResponse;
import com.yoda.yodatore.repository.KichThuocRepository;

import com.yoda.yodatore.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KichThuocServiceImpl implements KichThuocService {
    @Autowired
    private KichThuocRepository repository;

    @Autowired
    private KichThuocConvert kichThuocConvert;

    public PhanTrang<KichThuocResponse> getAll(KichThuocRequest request) {
        return new PhanTrang<>(repository.getAllKichThuoc(request, PageRequest.of(request.getPage() - 1, 5)));
    }


    public KichThuoc getOne(Long id) {
        return repository.findById(id).get();
    }


    public KichThuoc add(KichThuocRequest request) {
        if (repository.existsByNameIgnoreCase(request.getName())) {
            throw new NgoaiLe("Kích thước " + request.getName() + " đã tồn tại!");
        }
        KichThuoc kichThuoc = kichThuocConvert.addconvertRequest(request);
        return repository.save(kichThuoc);
    }

    public KichThuoc update(Long id, KichThuocRequest request) {
        KichThuoc name = repository.findById(id).get();
        if (repository.existsByNameIgnoreCase(request.getName())) {
           if (name.getName().equals(request.getName())){
               return repository.save(kichThuocConvert.convertRequestToEntity(name,request));
           }
            throw new NgoaiLe("Kích thước " + request.getName() + " đã tồn tại!");
        }else {
            return repository.save(kichThuocConvert.convertRequestToEntity(name,request));
        }


    }

    public KichThuoc delete(Long id) {
        KichThuoc kichThuoc = this.getOne(id);
        kichThuoc.setDeleted(!kichThuoc.getDeleted());
        return repository.save(kichThuoc);
    }
}
