package com.yoda.yodatore.infrastructure.common;

import com.yoda.yodatore.infrastructure.constant.PhanTrangConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PageableRequest {
    private int page = PhanTrangConstant.DEFAULT_PAGE;
    private int sizePage = PhanTrangConstant.DEFAULT_SIZE;
}