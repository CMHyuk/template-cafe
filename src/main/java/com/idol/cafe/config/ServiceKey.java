package com.idol.cafe.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "service-key")
public class ServiceKey {
    private String serviceKey;
}
