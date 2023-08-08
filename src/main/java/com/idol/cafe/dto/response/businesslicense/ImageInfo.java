package com.idol.cafe.dto.response.businesslicense;

import lombok.Getter;

@Getter
public class ImageInfo {
    private BizLicense bizLicense;
    private String uid;
    private String name;
    private String inferResult;
    private String message;
    private ValidationResult validationResult;
}
