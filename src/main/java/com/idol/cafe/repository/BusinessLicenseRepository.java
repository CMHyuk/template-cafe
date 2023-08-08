package com.idol.cafe.repository;

import com.idol.cafe.domain.entity.BusinessLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessLicenseRepository extends JpaRepository<BusinessLicense, Long> {
    Boolean existsByRegistrationNumber(String registrationNumber);
}
