package com.idol.cafe.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.idol.cafe.config.S3Config;
import com.idol.cafe.domain.entity.BusinessLicense;
import com.idol.cafe.dto.response.businesslicense.BusinessLicenseResponse;
import com.idol.cafe.repository.BusinessLicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BusinessLicenseService {

    private final BusinessLicenseRepository businessLicenseRepository;
    private final S3Config s3Config;
    private final AmazonS3Client amazonS3;

    public void uploadBusinessLicense(MultipartFile file) throws IOException {
        String s3FileName = UUID.randomUUID() + "-" + file.getOriginalFilename();

        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentLength(file.getInputStream().available());
        amazonS3.putObject(s3Config.getBucket(), s3FileName, file.getInputStream(), objMeta);

        amazonS3.getUrl(s3Config.getBucket(), s3FileName).toString();
    }

    public void saveRegisterNumber(BusinessLicenseResponse businessLicenseResponse) {
        String registerNumber = getRegisterNumber(businessLicenseResponse);
        if (businessLicenseRepository.existsByRegistrationNumber(registerNumber)) {
            throw new IllegalArgumentException("이미 등록된 사업자등록번호입니다.");
        }

        BusinessLicense businessLicense = new BusinessLicense(registerNumber);
        businessLicenseRepository.save(businessLicense);
    }

    private String getRegisterNumber(BusinessLicenseResponse businessLicenseResponse) {
        return businessLicenseResponse.getImages().get(0).getBizLicense().getResult()
                .getRegisterNumber().get(0).getText();
    }

}
