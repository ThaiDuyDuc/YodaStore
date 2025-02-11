package com.yoda.yodatore.controller;


import com.yoda.yodatore.entity.LichSuHoaDon;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.common.ResponseObject;
import com.yoda.yodatore.infrastructure.response.LichSuHoaDonReponse;
import com.yoda.yodatore.service.LichSuHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lichsuhoadon")
public class LichSuHoaDonController {


    @Autowired
    private LichSuHoaDonService service;

    @GetMapping
    public PhanTrang<LichSuHoaDonReponse> getAll(
            @RequestParam(required = false,defaultValue = "1") Integer page
    ){
        return service.getAll(page);
    }

    @GetMapping("/{id}")
    public LichSuHoaDon getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @PostMapping("")
    public ResponseObject add(@RequestBody @Validated LichSuHoaDon lichSuHoaDon) {
        return new ResponseObject(service.add(lichSuHoaDon));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Validated LichSuHoaDon lichSuHoaDon) {
        return new ResponseObject(service.update(id, lichSuHoaDon));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id){
        return new ResponseObject(service.delete(id));
    }

}
