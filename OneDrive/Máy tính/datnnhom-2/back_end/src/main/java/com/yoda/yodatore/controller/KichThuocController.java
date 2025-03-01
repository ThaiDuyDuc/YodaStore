package com.yoda.yodatore.controller;


import com.yoda.yodatore.entity.KichThuoc;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.common.ResponseObject;
import com.yoda.yodatore.infrastructure.request.KichThuocRequest;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import com.yoda.yodatore.infrastructure.response.KichThuocResponse;
import com.yoda.yodatore.infrastructure.response.MauSacResponse;
import com.yoda.yodatore.service.KichThuocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/size")
public class KichThuocController {
    @Autowired
    private KichThuocService kichThuocService;

    @GetMapping
    public PhanTrang<KichThuocResponse> getAll(KichThuocRequest request) {
        return kichThuocService.getAll(request);
    }

    @GetMapping("/{id}")
    public KichThuoc getOne(@PathVariable Long id) {
        return kichThuocService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid KichThuocRequest request) {
        return new ResponseObject(kichThuocService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid KichThuocRequest request) {
        return new ResponseObject(kichThuocService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(kichThuocService.delete(id));
    }
}
