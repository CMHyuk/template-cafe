package com.idol.cafe.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Collections;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    private static final String OCR_URL = "https://ng9uv3ttrl.apigw.ntruss.com/custom/v1/24289/3e818bfd9c5ba0c0cbb341e28a7636c91bd0b012a236a510c6e149e62fa95621/document/biz-license";
    public static final String NATIONAL_TAX_SERVICE_URL = "api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=avuD%2BjmTxg%2Fpn4CWUsCpjHe5C5qITGrrqYX89SC1wdBKDa%2B8%2FbMVe3n5EM8kgzPCVH0fFiXmEsaHLGAbymLRBw%3D%3D";


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
                .baseUrl(OCR_URL)
                .build();
    }

    @Bean
    public WebClient confirmRegisterNumber() {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(NATIONAL_TAX_SERVICE_URL);
        factory.setEncodingMode(VALUES_ONLY);

        return WebClient.builder()
                .uriBuilderFactory(factory)
                .build();
    }

}
