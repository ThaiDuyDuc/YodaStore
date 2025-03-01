package com.yoda.yodatore.infrastructure.common;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PhanTrang<T> {
    private List<T> data;
    private long totalPages;
    private int currentPage;

    public PhanTrang(Page<T> page) {
        this.data = page.getContent();
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber();
    }
}
