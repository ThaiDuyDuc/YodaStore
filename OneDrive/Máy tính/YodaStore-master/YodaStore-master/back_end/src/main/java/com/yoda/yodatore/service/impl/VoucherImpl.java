package com.yoda.yodatore.service.impl;


import com.yoda.yodatore.entity.Voucher;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.response.VoucherResponse;
import com.yoda.yodatore.repository.VoucherRepository;
import com.yoda.yodatore.service.VoucherService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoucherImpl implements VoucherService {

    @Autowired
    private VoucherRepository repository;

    @Override
    public PhanTrang<VoucherResponse> getAll(Integer page) {
        return new PhanTrang<>(repository.getAll(PageRequest.of(page - 1, 5)));
    }

    @Override
    public Voucher getOne(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public ResponseEntity<?> add(Voucher voucher) {

        List<String> errors = new ArrayList<>();

        if (voucher.getGiaTriToiThieu() == null) errors.add("Giá trị tối thiểu không được để trống");
        if (voucher.getPhanTramGiam() == null) errors.add("Phần trăm giảm không được để trống");
        if (voucher.getSoLuong() == null || voucher.getSoLuong() < 1) errors.add("Số lượng phải lớn hơn 0");
        if (voucher.getTrangThai() == null) errors.add("Trạng thái không được để trống");
        if (voucher.getLoai() == null) errors.add("Loại không được để trống");
        if (voucher.getNgayBatDau() == null || voucher.getNgayKetThuc() == null) errors.add("Ngày bắt đầu và ngày kết thúc không được để trống");
        if (voucher.getNgayKetThuc() != null && voucher.getNgayBatDau() != null && voucher.getNgayKetThuc().isBefore(voucher.getNgayBatDau())) {
            errors.add("Ngày kết thúc phải sau ngày bắt đầu");
        }
        if (voucher.getCode() == null || voucher.getCode().isBlank()) errors.add("Mã giảm giá không được để trống");
        if (voucher.getName() == null || voucher.getName().isBlank()) errors.add("Tên không được để trống");

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok(repository.save(voucher));
    }

    @Override
    public Voucher update(Long id, Voucher voucher) {
        Voucher voucher1 = this.getOne(id); // Lấy voucher từ DB

        // Cập nhật các giá trị mới
        voucher1.setGiaTriToiThieu(voucher.getGiaTriToiThieu());
        voucher1.setPhanTramGiam(voucher.getPhanTramGiam());
        voucher1.setSoLuong(voucher.getSoLuong());
        voucher1.setTrangThai(voucher.getTrangThai());
        voucher1.setLoai(voucher.getLoai());
        voucher1.setNgayBatDau(voucher.getNgayBatDau());
        voucher1.setNgayKetThuc(voucher.getNgayKetThuc());
        voucher1.setCode(voucher.getCode());
        voucher1.setName(voucher.getName());

        // LƯU lại vào database
        return repository.save(voucher1);
    }


    @Override
    public Voucher delete(Long id) {
        Optional<Voucher> voucher = repository.findById(id);
        if(voucher.isEmpty()){
            throw new EntityNotFoundException("Không tìm thấy lịch sử hóa đơn có ID: " + id);
        }
        repository.deleteById(id);

        return voucher.get();
    }
}
