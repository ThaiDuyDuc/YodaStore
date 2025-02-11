package com.yoda.yodatore.infrastructure.common;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PhanTrang<phanTrang> {
    private List<phanTrang> data;
    private long tongTrang;
    private int trangHienTai;
    
    public PhanTrang(Page<phanTrang> page){
        this.data = page.getContent();
        this.tongTrang = page.getTotalPages();
        this.trangHienTai = page.getNumber();
    }
}
