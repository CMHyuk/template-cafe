package com.idol.cafe.service;

import com.idol.cafe.domain.entity.BusinessLicense;
import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.repository.BusinessLicenseRepository;
import com.idol.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final CafeRepository cafeRepository;
    private final BusinessLicenseRepository businessLicenseRepository;

    public Page<Cafe> getCafes(Pageable pageable) {
        return cafeRepository.findAll(pageable);
    }

    public Page<BusinessLicense> getBusinessLicense(Pageable pageable) {
        return businessLicenseRepository.findAll(pageable);
    }

    @Transactional
    public void updateRegisteredBusiness(Long businessLicenseId) {
        BusinessLicense businessLicense = businessLicenseRepository.findById(businessLicenseId)
                .orElseThrow();

        businessLicense.updateRegisteredBusiness(true);
    }

}
