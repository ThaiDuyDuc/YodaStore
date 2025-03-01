package com.yoda.yodatore.controller;

import com.yoda.yodatore.entity.MauSac;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.common.ResponseObject;
import com.yoda.yodatore.infrastructure.request.MauSacRequest;
import com.yoda.yodatore.infrastructure.response.MauSacResponse;
import com.yoda.yodatore.service.MauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/color")
public class MauSacController {

    @Autowired
    private MauSacService service;


    @GetMapping
    public PhanTrang<MauSacResponse> getAll(MauSacRequest request) {
        return service.getAll(request);
    }

    @GetMapping("/{id}")
    public MauSac getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public ResponseObject add(@RequestBody @Valid MauSacRequest request) {
        return new ResponseObject(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid MauSacRequest request) {
        return new ResponseObject(service.update(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id){
        return new ResponseObject(service.delete(id));
    }
}
