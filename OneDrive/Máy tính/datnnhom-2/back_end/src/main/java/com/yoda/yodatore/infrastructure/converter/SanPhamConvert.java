package com.yoda.yodatore.infrastructure.converter;


import com.yoda.yodatore.entity.SanPham;
import com.yoda.yodatore.infrastructure.request.SanPhamRequest;
import com.yoda.yodatore.repository.DanhMucRepository;
import com.yoda.yodatore.repository.DeRepository;
import com.yoda.yodatore.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class SanPhamConvert {
        @Autowired
        private ThuongHieuRepository thuongHieuRepository;

        @Autowired
        private DanhMucRepository danhMucRepository;

        @Autowired
        private DeRepository deRepository;
        public SanPham addconvertRequest(SanPhamRequest request){
                SanPham sanPham = SanPham.builder()
                        .name(request.getName())
                        .category(danhMucRepository.findById(request.getCategory()).get())
                        .brand(thuongHieuRepository.findById(request.getBrand()).get())
                        .sole(deRepository.findById(request.getSole()).get())
                        .build();
                return sanPham;
        }
        public SanPham convertRequestToEntity(SanPham sanPham, SanPhamRequest request){
                sanPham.setName(request.getName());
                sanPham.setCategory(danhMucRepository.findById(request.getCategory()).get());
                sanPham.setBrand(thuongHieuRepository.findById(request.getBrand()).get());
                sanPham.setSole(deRepository.findById(request.getSole()).get());
                return sanPham;
        }
}
