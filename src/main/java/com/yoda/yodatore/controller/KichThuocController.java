package com.yoda.yodatore.controller;

import com.yoda.yodatore.entity.KichThuoc;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.common.ResponseObject;
import com.yoda.yodatore.infrastructure.response.KichThuocReponse;
import com.yoda.yodatore.service.KichThuocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kichthuoc")
public class KichThuocController {
    @Autowired
    private KichThuocService service;

    @GetMapping
    public PhanTrang<KichThuocReponse> getAll(
            @RequestParam(required = false,defaultValue = "") String name,
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "") Boolean status){
            return service.getAll(name,page,status);
    }



    @GetMapping("/{id}")
    public KichThuoc getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public ResponseObject add(@RequestBody @Valid KichThuoc kichThuoc) {
        return new ResponseObject(service.add(kichThuoc));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid KichThuoc kichThuoc) {
        return new ResponseObject(service.update(id, kichThuoc));
    }


    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id){
        return new ResponseObject(service.delete(id));
    }
}
