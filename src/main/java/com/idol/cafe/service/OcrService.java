package com.idol.cafe.service;

import com.idol.cafe.config.WebClientConfig;
import com.idol.cafe.dto.response.businesslicense.BusinessLicenseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Service
@RequiredArgsConstructor
public class OcrService {

    private final WebClientConfig webClientConfig;

    public BusinessLicenseResponse getBusinessLicenseInfo(byte[] imageData, String imageName) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("version", "V2");
        requestBody.put("requestId", UUID.randomUUID().toString());
        requestBody.put("timestamp", System.currentTimeMillis());

        List<Map<String, String>> images = new ArrayList<>();
        Map<String, String> imageInfo = new HashMap<>();
        imageInfo.put("format", "jpg");
        imageInfo.put("data", Base64.getEncoder().encodeToString(imageData));
        imageInfo.put("name", imageName);
        images.add(imageInfo);

        requestBody.put("images", images);

        return webClientConfig.ocr().post()
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .header("X-OCR-SECRET", "TUlRaXpkb21EU2RVd21JamJubm9laG9mQ1JKeHhQVHM=")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(BusinessLicenseResponse.class)
                .block();
    }

}
