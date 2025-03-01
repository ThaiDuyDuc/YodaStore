package com.yoda.yodatore.infrastructure.request;

import com.yoda.yodatore.infrastructure.common.PageableRequest;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class SanPhamRequest extends PageableRequest {
    private Long id;
    @NotEmpty(message = "Tên không được để trống.")
    private String name;
    @NotNull(message = "Thương hiệu không được để trống.")
    private Long brand;
    @NotNull(message = "Danh mục không được để trống.")
    private Long category;
    @NotNull(message = "Vui lòng chọn loại đế!")
    private Long sole;
    private Boolean status;
}
