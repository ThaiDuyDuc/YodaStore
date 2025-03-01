package com.yoda.yodatore.infrastructure.request;
import com.yoda.yodatore.infrastructure.common.PageableRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DanhMucRequest extends PageableRequest{
    private Long id;
    @NotEmpty(message = "Danh mục không được để trống")
    private String name;
    private Boolean status;
}
