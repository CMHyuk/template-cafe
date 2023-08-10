package com.idol.cafe.controller;

import com.idol.cafe.dto.response.businesslicense.BusinessLicenseResponse;
import com.idol.cafe.service.BusinessLicenseService;
import com.idol.cafe.service.OcrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class BusinessLicenseController {

    private final BusinessLicenseService businessLicenseService;
    private final OcrService ocrService;

    @PostMapping("/save/businessLicense")
    public void get(@RequestParam("file") MultipartFile file) throws IOException {
        businessLicenseService.uploadBusinessLicense(file);
        byte[] imageBytes = file.getBytes();
        BusinessLicenseResponse businessLicenseInfo = ocrService.getBusinessLicenseInfo(imageBytes, "사업자 등록증");
        businessLicenseService.saveRegisterNumber(businessLicenseInfo);
    }

}
