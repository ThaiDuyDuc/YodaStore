package com.yoda.yodatore.controller;

import com.yoda.yodatore.entity.De;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.common.ResponseObject;
import com.yoda.yodatore.infrastructure.request.DeRequest;
import com.yoda.yodatore.infrastructure.request.KichThuocRequest;
import com.yoda.yodatore.infrastructure.response.DeResponse;
import com.yoda.yodatore.infrastructure.response.KichThuocResponse;
import com.yoda.yodatore.service.DeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sole")
public class DeController {
    @Autowired
    private DeService deService;

    @GetMapping
    public PhanTrang<DeResponse> getAll(DeRequest request) {
        return deService.getAll(request);
    }

    @GetMapping("/{id}")
    public De getOne(@PathVariable Long id) {
        return deService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid DeRequest request) {
        return new ResponseObject(deService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid DeRequest request) {
        return new ResponseObject(deService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(deService.delete(id));

    }
}
