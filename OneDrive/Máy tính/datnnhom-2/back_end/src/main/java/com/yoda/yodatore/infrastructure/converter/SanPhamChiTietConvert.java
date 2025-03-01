package com.yoda.yodatore.infrastructure.converter;

import com.yoda.yodatore.entity.SanPham;
import com.yoda.yodatore.entity.MauSac;
import com.yoda.yodatore.entity.De;
import com.yoda.yodatore.entity.KichThuoc;
import com.yoda.yodatore.infrastructure.common.GenCode;
import com.yoda.yodatore.infrastructure.request.SanPhamChiTietRequest;
import com.yoda.yodatore.repository.KichThuocRepository;
import com.yoda.yodatore.repository.MauSacRepository;
import com.yoda.yodatore.repository.SanPhamRepository;
import com.yoda.yodatore.repository.DeRepository;
import com.yoda.yodatore.entity.SanPhamChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SanPhamChiTietConvert {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private KichThuocRepository kichThuocRepository;
    @Autowired
    private DeRepository deRepository;

    public SanPhamChiTiet convertRequestToEntity(SanPhamChiTietRequest request) {
        SanPham sanPham = sanPhamRepository.findById(request.getShoe()).get();
        MauSac mauSac = mauSacRepository.findById(request.getColor()).get();
        KichThuoc kichThuoc = kichThuocRepository.findById(request.getSize()).get();

        return SanPhamChiTiet.builder()
                .shoe(sanPham).color(mauSac).size(kichThuoc)
                .code(GenCode.genCodeByName(sanPham.getName()
                        + mauSac.getName() + kichThuoc.getName()))
                .price(request.getPrice()).quantity(request.getQuantity())
                .weight(request.getWeight())
                .build();
    }

    public SanPhamChiTiet convertRequestToEntity(SanPhamChiTiet entity, SanPhamChiTietRequest request) {
        SanPham sanPham = sanPhamRepository.findById(request.getShoe()).get();
        MauSac mauSac = mauSacRepository.findById(request.getColor()).get();
        KichThuoc kichThuoc = kichThuocRepository.findById(request.getSize()).get();


        entity.setShoe(sanPham);
        entity.setColor(mauSac);
        entity.setSize(kichThuoc);
        entity.setCode(GenCode.genCodeByName(sanPham.getName()
                + mauSac.getName() + kichThuoc.getName()));
        entity.setPrice(request.getPrice());
        entity.setQuantity(request.getQuantity());
        entity.setWeight(request.getWeight());
        return entity;
    }
}
