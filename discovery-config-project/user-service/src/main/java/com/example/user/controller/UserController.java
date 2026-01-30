package com.example.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RefreshScope // POST /actuator/busrefresh 요청 시 새로 고침되는 Bean.
@RequiredArgsConstructor
public class UserController {

    private final Environment env; // 환경 변수 담당

    @Value("${user.welcome.message:기본메시지}")
    private String message;

    @GetMapping("/message")
    public String message() {
        return String.format("User Service on %s: %s", env.getProperty("local.server.port"), message);
    }
}
