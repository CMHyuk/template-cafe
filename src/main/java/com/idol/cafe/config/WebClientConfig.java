package com.idol.cafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@Configuration
public class WebClientConfig {

    private static final String ocrUrl = "https://ng9uv3ttrl.apigw.ntruss.com/custom/v1/24289/3e818bfd9c5ba0c0cbb341e28a7636c91bd0b012a236a510c6e149e62fa95621/document/biz-license";

    @Bean
    public WebClient kakao() {
        return WebClient.builder()
                .baseUrl("https://kapi.kakao.com")
                .defaultHeader(CONTENT_TYPE, APPLICATION_FORM_URLENCODED_VALUE)
                .build();
    }

    @Bean
    public WebClient ocr() {
        return WebClient.builder()
                .baseUrl(ocrUrl)
                .build();
    }

    @Bean
    public WebClient nationalTaxService() {
        return WebClient.builder()
                .baseUrl("https://api.odcloud.kr/api/validate")
                .build();
    }

}
