package com.yoda.yodatore.controller;


import com.yoda.yodatore.entity.Voucher;
import com.yoda.yodatore.infrastructure.common.PhanTrang;
import com.yoda.yodatore.infrastructure.common.ResponseObject;
import com.yoda.yodatore.infrastructure.request.VoucherRequest;
import com.yoda.yodatore.service.VoucherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @GetMapping
    public PhanTrang getAll(final VoucherRequest request) {
        return voucherService.getAll(request);
    }

    @PostMapping("add")
    public ResponseObject addVoucher(@ModelAttribute @Valid VoucherRequest request) {

        return new ResponseObject(voucherService.add(request));

    }

    @PutMapping("/update/{id}")
    public ResponseObject updateVocher(@ModelAttribute @Valid VoucherRequest request, @PathVariable Long id) {

        return new ResponseObject(voucherService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voucher> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(voucherService.getOne(id), HttpStatus.OK);
    }
}
