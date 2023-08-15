package com.idol.cafe.controller;

import com.idol.cafe.config.Login;
import com.idol.cafe.dto.request.LoginUser;
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

    @PostMapping("/businessLicense/save")
    public void get(@Login LoginUser loginUser, @RequestParam("file") MultipartFile file) throws IOException {
        businessLicenseService.uploadBusinessLicense(file);
        BusinessLicenseResponse businessLicenseInfo = ocrService.getBusinessLicenseInfo(file, "사업자 등록증");
        businessLicenseService.saveRegistrationNumber(loginUser, businessLicenseInfo);
    }

}
