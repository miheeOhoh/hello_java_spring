package io.namoosori.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  // ectuator 관련 추가한 어노테이션
public class ConfigClientController {

    @Value("${test.str}")
    private String configStr;
    // test-str의 값이 configStr에 주입된다.

    @Value("${namoosori.value}")
    private String configStr2;

    @GetMapping("/test")
    public String test() {
        return configStr;
    }

    @GetMapping("/config/test")
    public String configTest() {
        return configStr2;
    }
}
