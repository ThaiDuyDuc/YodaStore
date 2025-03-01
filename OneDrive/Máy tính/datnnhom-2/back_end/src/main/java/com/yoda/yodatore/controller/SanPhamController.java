package com.yoda.yodatore.controller;

import com.yoda.yodatore.entity.SanPham;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.common.ResponseObject;
import com.yoda.yodatore.infrastructure.request.SanPhamRequest;
import com.yoda.yodatore.infrastructure.response.SanPhamResponse;
import com.yoda.yodatore.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shoe")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping
    public PhanTrang<SanPhamResponse> getAll(SanPhamRequest request) {
        return sanPhamService.getAll(request);
    }

    @GetMapping("/{id}")
    public SanPham getOne(@PathVariable Long id) {
        return sanPhamService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid SanPhamRequest request) {
        return new ResponseObject(sanPhamService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid SanPhamRequest request){
        return new ResponseObject(sanPhamService.update(id,request));
    }
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(sanPhamService.delete(id));
    }
}
