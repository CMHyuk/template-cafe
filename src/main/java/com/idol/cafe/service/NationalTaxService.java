package com.idol.cafe.service;

import com.idol.cafe.config.ServiceKey;
import com.idol.cafe.config.WebClientConfig;
import com.idol.cafe.dto.request.BusinessLicenseRequest;
import com.idol.cafe.dto.response.businesslicense.BusinessLicenseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.idol.cafe.config.WebClientConfig.NATIONAL_TAX_SERVICE_URL;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Service
@RequiredArgsConstructor
public class NationalTaxService {

    private final WebClientConfig webClientConfig;

    public BusinessLicenseStatus confirmBusinessLicenseStatus(String registerNumber) {
        BusinessLicenseRequest request = new BusinessLicenseRequest(List.of(registerNumber));

        return webClientConfig.confirmRegisterNumber().post()
                .contentType(APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToFlux(BusinessLicenseStatus.class)
                .blockLast();
    }

}
