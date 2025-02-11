package com.example.demo.infrastructure.common;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PhanTrang<T> {
    private List<T> data;
    private long tongTrang;
    private int trangHienTai;
    
    public PhanTrang(Page<T> page){
        this.data = page.getContent();
        this.tongTrang = page.getTotalPages();
        this.trangHienTai = page.getNumber();
    }
}
