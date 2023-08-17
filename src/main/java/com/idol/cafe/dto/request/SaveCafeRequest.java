package com.idol.cafe.dto.request;

import com.idol.cafe.domain.Address;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class SaveCafeRequest {
    private String cafeName;
    private String introduction;
    private MultipartFile file;
    private Address address;
}
