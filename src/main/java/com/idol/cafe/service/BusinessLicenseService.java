package com.idol.cafe.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.idol.cafe.config.S3Config;
import com.idol.cafe.domain.entity.BusinessLicense;
import com.idol.cafe.dto.response.businesslicense.BusinessLicenseResponse;
import com.idol.cafe.dto.response.businesslicense.BusinessLicenseStatus;
import com.idol.cafe.exception.BusinessRegistrationError;
import com.idol.cafe.exception.DuplicationRegistrationNumber;
import com.idol.cafe.repository.BusinessLicenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BusinessLicenseService {

    private final NationalTaxService nationalTaxService;
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

    public void saveRegistrationNumber(BusinessLicenseResponse businessLicenseResponse) {
        String RegistrationNumber = getRegisterNumber(businessLicenseResponse);
        if (businessLicenseRepository.existsByRegistrationNumber(RegistrationNumber)) {
            throw new DuplicationRegistrationNumber();
        }

        BusinessLicenseStatus businessLicenseStatus = nationalTaxService.confirmBusinessLicenseStatus(RegistrationNumber);
        String taxType = getTaxType(businessLicenseStatus);
        if (taxType.equals("국세청에 등록되지 않은 사업자등록번호입니다.")) {
            throw new BusinessRegistrationError();
        }

        BusinessLicense businessLicense = new BusinessLicense(RegistrationNumber);
        businessLicenseRepository.save(businessLicense);
    }

    private String getRegisterNumber(BusinessLicenseResponse businessLicenseResponse) {
        //610-81-54020 -> 6108154020
        return businessLicenseResponse.getImages().get(0).getBizLicense().getResult()
                .getRegisterNumber().get(0).getText().replace("-", "");
    }

    private String getTaxType(BusinessLicenseStatus businessLicenseStatus) {
        return businessLicenseStatus.getData().get(0).getTax_type();
    }

}
