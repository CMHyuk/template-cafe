package com.idol.cafe.dto.request;

import com.idol.cafe.domain.Address;
import lombok.Getter;

@Getter
public class SaveCafeRequest {
    private String cafeName;
    private String introduction;
    private String imageUrl;
    private Address address;
}
