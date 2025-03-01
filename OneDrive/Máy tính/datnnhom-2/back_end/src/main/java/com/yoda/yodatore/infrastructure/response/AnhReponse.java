package com.yoda.yodatore.infrastructure.response;

import com.yoda.yodatore.entity.Images;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Images.class})
public interface AnhReponse {
    Long getId();

    String getName();
}
