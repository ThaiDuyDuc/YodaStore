package com.yoda.yodatore.service.impl;

import com.yoda.yodatore.entity.SanPham;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.converter.SanPhamConvert;
import com.yoda.yodatore.infrastructure.exception.NgoaiLe;
import com.yoda.yodatore.infrastructure.request.SanPhamRequest;
import com.yoda.yodatore.infrastructure.response.SanPhamResponse;
import com.yoda.yodatore.repository.SanPhamRepository;
import com.yoda.yodatore.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private SanPhamConvert sanPhamConvert;

    public PhanTrang<SanPhamResponse> getAll(SanPhamRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSizePage());
        return new PhanTrang<>(sanPhamRepository.getAllShoe(request, pageable));

    }

    public SanPham getOne(Long id){
        return sanPhamRepository.findById(id).get();
    }

    public SanPham create(SanPhamRequest request) {
        if (sanPhamRepository.existsByNameIgnoreCase(request.getName())) {
            throw new NgoaiLe(request.getName() + " đã tồn tại");
        }
        SanPham sanPham = sanPhamConvert.addconvertRequest(request);
        return sanPhamRepository.save(sanPham);
    }
    public SanPham update(Long id, SanPhamRequest request) {
        SanPham name = sanPhamRepository.findById(id).get();
        if (sanPhamRepository.existsByNameIgnoreCase(request.getName())) {
            if (name.getName().equals(request.getName())) {
                return sanPhamRepository.save(sanPhamConvert.convertRequestToEntity(name, request));
            }
            throw new NgoaiLe(request.getName() + " đã tồn tại!");
        } else {
            return sanPhamRepository.save(sanPhamConvert.convertRequestToEntity(name, request));
        }
    }
    //    public SanPham delete(Long id) {
//        return null;
//    }
    public SanPham delete(Long id) {
        SanPham sanPham = this.getOne(id);
        sanPham.setDeleted(!sanPham.getDeleted());
        return sanPhamRepository.save(sanPham);
    }
}
