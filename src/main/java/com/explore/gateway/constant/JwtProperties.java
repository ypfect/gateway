package com.explore.gateway.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/2/2 11:41
 */
@ConfigurationProperties(prefix = "jwt")
@Component
@Getter
@Setter
public class JwtProperties {
    private String url;
    private String header;
    private String prefix;
    private int expiration; // default 24 hours
    private String secret;
    public JwtProperties() {
    }
}
