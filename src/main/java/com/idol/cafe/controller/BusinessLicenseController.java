package com.idol.cafe.controller;

import com.idol.cafe.dto.response.businesslicense.BusinessLicenseResponse;
import com.idol.cafe.service.BusinessLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class BusinessLicenseController {

    private final BusinessLicenseService businessLicenseService;

    @PostMapping("/businessLicense/upload")
    public void upload(MultipartFile multipartFile) throws IOException {
        businessLicenseService.uploadBusinessLicense(multipartFile);
    }

    //naver ocr 승인되면 webClient로 리팩토링
    @PostMapping("/businessLicense/save")
    public void save(BusinessLicenseResponse businessLicenseResponse) {
        businessLicenseService.saveRegisterNumber(businessLicenseResponse);
    }

}
