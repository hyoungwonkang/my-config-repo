package com.example.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 새로 고침되는 Bean입니다. (post http://localhost:9092/actuator/refresh 요청 시)
public class OrderController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public String port() {
        return "Order port:" + port;
    }
}
