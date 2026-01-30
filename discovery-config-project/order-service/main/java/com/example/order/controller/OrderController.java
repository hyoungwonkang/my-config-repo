package com.example.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 새로 고침되는 Bean입니다. (post http://localhost:9091/actuator/refresh 요청 시)
public class ProductController {
    @Value("${message.owner:기본오너}")
    private String owner;

    @Value("${message.content:기본내용}")
    private String content;

    @GetMapping("/message")
    public String message() {
        return owner + "(" + content + ")";
    }
}
