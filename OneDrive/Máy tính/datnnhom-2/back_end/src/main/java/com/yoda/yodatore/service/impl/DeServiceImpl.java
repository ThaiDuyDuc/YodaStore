package com.yoda.yodatore.service.impl;


import com.yoda.yodatore.entity.DanhMuc;
import com.yoda.yodatore.entity.De;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.converter.DeConvert;
import com.yoda.yodatore.infrastructure.exception.NgoaiLe;
import com.yoda.yodatore.infrastructure.request.DanhMucRequest;
import com.yoda.yodatore.infrastructure.request.DeRequest;
import com.yoda.yodatore.infrastructure.response.DeResponse;
import com.yoda.yodatore.repository.DeRepository;
import com.yoda.yodatore.service.DeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DeServiceImpl implements DeService {
    @Autowired
    private DeRepository repository;

    @Autowired
    private DeConvert deConvert;
    public PhanTrang<DeResponse> getAll(DeRequest request) {
        return new PhanTrang<>(repository.getAllDe(request, PageRequest.of(request.getPage() - 1, 5)));
    }
    public De getOne(Long id) {
        return repository.findById(id).get();
    }


    public De add(DeRequest request) {
        if (repository.existsByNameIgnoreCase(request.getName())) {
            throw new NgoaiLe("Đế giày " + request.getName() + " đã tồn tại!");
        }
        De de = deConvert.addconvertRequest(request);
        return repository.save(de);
    }



    public De update(Long id, DeRequest request) {
        De name = repository.findById(id).get();
        if (repository.existsByNameIgnoreCase(request.getName())) {
            if (name.getName().equals(request.getName())){
                return repository.save(deConvert.convertRequestToEntity(name,request));
            }
            throw new NgoaiLe("Đế giày " + request.getName() + " đã tồn tại!");
        }
        else {
            return repository.save(deConvert.convertRequestToEntity(name,request));
        }


    }


    public De delete(Long id) {
        De name = this.getOne(id);
        name.setDeleted(!name.getDeleted());
        return repository.save(name);
    }
}
