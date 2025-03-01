package com.yoda.yodatore.controller;

import com.yoda.yodatore.entity.DanhMuc;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.common.ResponseObject;
import com.yoda.yodatore.infrastructure.request.DanhMucRequest;
import com.yoda.yodatore.infrastructure.response.DanhMucResponse;
import com.yoda.yodatore.infrastructure.response.DeResponse;
import com.yoda.yodatore.service.DanhMucService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class DanhMucController {
    @Autowired
    private DanhMucService danhMucService;

    @GetMapping
    public PhanTrang<DanhMucResponse> getAll(DanhMucRequest request) {
        return danhMucService.getAll(request);
    }

    @GetMapping("/{id}")
    public DanhMuc getOne(@PathVariable Long id) {
        return danhMucService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid DanhMucRequest request) {
        return new ResponseObject(danhMucService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid DanhMucRequest request) {
        return new ResponseObject(danhMucService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(danhMucService.delete(id));

    }

}
