package com.marcel.prometheusgrafana.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PrometheusGrafanaController {

    @GetMapping("/test")
    public String testMethod() {
        log.error("Test error method");
        log.info("Test info method");
        return "success";
    }
}
